package com.najman.microservices.service;

import com.najman.microservices.dto.InventoryResponse;
import com.najman.microservices.model.Inventory;
import com.najman.microservices.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }


    public List<InventoryResponse> getAllInventories() {
        java.util.List<Inventory> allInventories = inventoryRepository.findAll();
        return allInventories.stream()
                .map(this::mapToDto)
                .toList();
    }

    private InventoryResponse mapToDto(Inventory inventory) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setSkuCode(inventory.getSkuCode());
        inventoryResponse.setQuantity(inventory.getQuantity());
        return inventoryResponse;
    }
}
