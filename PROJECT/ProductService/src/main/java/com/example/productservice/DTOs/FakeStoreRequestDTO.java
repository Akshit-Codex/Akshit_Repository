package com.example.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreRequestDTO
{
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
