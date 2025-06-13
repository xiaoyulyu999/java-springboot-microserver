package com.java_microserver.productservice.service;

import com.java_microserver.productservice.dto.ProductRequestDTO;
import com.java_microserver.productservice.dto.ProductResponseDTO;
import com.java_microserver.productservice.model.Product;
import com.java_microserver.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

//    public void createProduct(ProductRequest productRequest) {
//        Product product = mapToProduct(productRequest);
//        productRepository.save(product);
//        log.info("Product created: {}", product);
//    }

    public void createProductDTO(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.productRequestDTOToProduct(productRequestDTO);
        productRepository.save(product);
        log.info("Product created: {}", product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

//    private Product mapToProduct(ProductRequest productRequest) {
//        return Product.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .price(productRequest.getPrice())
//                .build();
//    }
//
//    private ProductResponse mapToProductResponse(Product product) {
//        return ProductResponse.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
//    }
}
