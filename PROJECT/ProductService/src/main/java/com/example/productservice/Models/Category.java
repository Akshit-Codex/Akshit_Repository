package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends Base
{
    @OneToMany(mappedBy = "category")
    List<Product> products;

    //@OneToMany
    //List<Product> featuredProducts;
}
