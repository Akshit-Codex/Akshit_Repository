package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base
{
    private double price;
    private String description;
    private String imageURL;
    @ManyToOne
    private Category category;
}
