package com.najman.microservices.service;

import com.najman.microservices.dto.InventoryResponse;
import com.najman.microservices.dto.OrderLineItemsDto;
import com.najman.microservices.dto.OrderRequest;
import com.najman.microservices.model.Order;
import com.najman.microservices.model.OrderLineItems;
import com.najman.microservices.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> listOfOrders = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(listOfOrders);

        List<String> listOfSkuCodes = order.getOrderLineItemsList().stream()
                .map(
                        OrderLineItems::getSkuCode
                ).toList();

        InventoryResponse[] inventoryResponses = webClient.get().uri("http://localhost:8083/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("listOfskuCodes", listOfSkuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        assert inventoryResponses != null;
        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());

        return orderLineItems;
    }

}
