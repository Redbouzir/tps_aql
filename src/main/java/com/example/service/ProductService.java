package com.example.service;

import com.example.api.ProductApiClient;
import com.example.api.ProductApiException;
import com.example.model.Product;

public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws ProductApiException {
        return productApiClient.getProduct(productId);
    }
} 