package com.java_microserver.productservice.service;

import com.java_microserver.productservice.dto.ProductRequestDTO;
import com.java_microserver.productservice.dto.ProductResponseDTO;
import com.java_microserver.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product productRequestDTOToProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.name());
        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        return product;
    }

    public ProductResponseDTO productToProductResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
