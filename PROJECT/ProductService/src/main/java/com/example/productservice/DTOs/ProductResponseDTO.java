package com.example.productservice.DTOs;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ProductResponseDTO
{
    private long ID;
    private String Name;
    private double price;
    private String description;
    private String image;
    private String category;

    public static ProductResponseDTO from(Product product)
    {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setID(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImage(product.getImageURL());
        productResponseDTO.setCategory(product.getCategory().getName());
        return productResponseDTO;
    }
}
