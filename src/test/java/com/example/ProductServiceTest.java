package com.example;

import com.example.api.ProductApiClient;
import com.example.api.ProductApiException;
import com.example.model.Product;
import com.example.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    @InjectMocks
    private ProductService productService;

    @Test
    void getProduct_ShouldReturnProduct_WhenApiCallSucceeds() throws ProductApiException {
        // Given
        String productId = "123";
        Product expectedProduct = new Product(productId, "Test Product", "Test Description", 99.99);
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);

        // When
        Product actualProduct = productService.getProduct(productId);

        // Then
        assertEquals(expectedProduct, actualProduct);
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test
    void getProduct_ShouldThrowException_WhenApiCallFails() throws ProductApiException {
        // Given
        String productId = "123";
        when(productApiClient.getProduct(productId))
                .thenThrow(new ProductApiException("API call failed"));

        // When & Then
        assertThrows(ProductApiException.class, () -> productService.getProduct(productId));
        verify(productApiClient, times(1)).getProduct(productId);
    }

    @Test
    void getProduct_ShouldThrowException_WhenInvalidDataFormat() throws ProductApiException {
        // Given
        String productId = "123";
        when(productApiClient.getProduct(productId))
                .thenThrow(new ProductApiException("Invalid data format"));

        // When & Then
        assertThrows(ProductApiException.class, () -> productService.getProduct(productId));
        verify(productApiClient, times(1)).getProduct(productId);
    }
} 