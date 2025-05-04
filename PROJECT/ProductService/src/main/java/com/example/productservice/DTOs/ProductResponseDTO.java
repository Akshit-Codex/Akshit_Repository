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
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

//    public ProductResponseDTO(Product product)
//    {
//        this.ID=product.getID();
//        this.title=product.getName();
//        this.price=product.getPrice();
//        this.description=product.getDescription();
//        this.image=product.getImageURL();
//        this.category=product.getCategory().getName();
//    }

    public static ProductResponseDTO from(Product product)
    {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setID(product.getID());
        productResponseDTO.setTitle(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImage(product.getImageURL());
        productResponseDTO.setCategory(product.getCategory().getName());
        return productResponseDTO;
    }
}
