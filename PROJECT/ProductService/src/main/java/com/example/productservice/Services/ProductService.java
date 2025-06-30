package com.example.productservice.Services;

import com.example.productservice.DTOs.CreateFakeStoreProductRequestDTO;
import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;

import java.util.List;

public interface ProductService
{
    Product getProductByID(long ID) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String name,double price,String description,String imageUrl,String category);
    Product replaceProduct(long id,String name,double price,String description,String imageUrl,String category);
}
