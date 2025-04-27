package com.example.api;

import com.example.model.Product;

public interface ProductApiClient {
    Product getProduct(String productId) throws ProductApiException;
} 