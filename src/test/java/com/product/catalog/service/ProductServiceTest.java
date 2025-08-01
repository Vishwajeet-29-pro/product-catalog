package com.product.catalog.service;

import com.product.catalog.entity.Product;
import com.product.catalog.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockitoBean
    private ProductRepository productRepository;

    @Autowired
    private CacheManager cacheManager;

    private Product product;

    @BeforeEach
    void setup() {
        product = new Product();
        product.setId("1");
        product.setName("Laptop");
        product.setDescription("High-end Laptop");
        product.setPrice(new BigDecimal("45000.00"));

        cacheManager.getCache("products").clear();
    }
}
