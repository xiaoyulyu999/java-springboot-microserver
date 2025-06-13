package com.java_microserver.productservice.service;

import com.java_microserver.productservice.dto.ProductRequest;
import com.java_microserver.productservice.dto.ProductResponse;
import com.java_microserver.productservice.model.Product;
import com.java_microserver.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = mapToProduct(productRequest);
        productRepository.save(product);
        log.info("Product created: {}", product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapToProductResponse)
                .toList();
    }

    private Product mapToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
