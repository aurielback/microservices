package com.najman.microservices;
import com.mongodb.assertions.Assertions;
import com.najman.microservices.dto.ProductRequest;
import com.najman.microservices.model.Product;
import com.najman.microservices.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
/*@Testcontainers
@AutoConfigureMockMvc*/
class ProductsApplicationTests {

  /*  @Container
    final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0.3"));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    private final ProductRepository productRepository;

    ProductsApplicationTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @BeforeEach
    void mongoDbContainerStarting() {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest product = getProduct();
        String productAsString = objectMapper.writeValueAsString(product);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productAsString)
        ).andExpect(
                status().isCreated()
        );

        List<Product> allProducts = productRepository.findAll();

        Assertions.assertTrue(allProducts.size() == 1);

    }

    private ProductRequest getProduct () {
        return ProductRequest.builder()
                .name("TestProdcut")
                .description("TestDescription")
                .price(BigDecimal.valueOf(1200))
                .build();
    }*/


}
