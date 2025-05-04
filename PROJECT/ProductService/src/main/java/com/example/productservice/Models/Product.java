package com.example.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product
{
    private long ID;
    private String name;
    private double price;
    private String description;
    private String imageURL;
    private Category category;
}
