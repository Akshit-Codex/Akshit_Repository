package com.example.productservice.Services;

import com.example.productservice.DTOs.FakeStoreResponseDTO;
import com.example.productservice.Models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreProductService implements ProductService
{
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductByID(long ID)
    {
        FakeStoreResponseDTO fakeStoreResponseDTO=restTemplate.
                getForObject("https://fakestoreapi.com/products/" + ID,
                        FakeStoreResponseDTO.class);
        return fakeStoreResponseDTO.toProduct();
    }
}
