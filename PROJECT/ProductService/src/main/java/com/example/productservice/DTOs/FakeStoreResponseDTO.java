package com.example.productservice.DTOs;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO
{
    private long ID;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public Product toProduct()
    {
        Product product=new Product();
        product.setId(ID);
        product.setName(title);
        product.setDescription(description);
        product.setImageURL(image);
        product.setPrice(price);

        Category category1=new Category();
        category1.setName(category);

        product.setCategory(category1);

        return product;
    }
}
