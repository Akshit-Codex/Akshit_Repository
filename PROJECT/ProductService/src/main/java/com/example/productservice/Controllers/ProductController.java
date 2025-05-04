package com.example.productservice.Controllers;

import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
    ProductService productService;
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/product/{ID}")
    public ProductResponseDTO getProductByID(@PathVariable long ID)
    {
        Product product=productService.getProductByID(ID);

        return ProductResponseDTO.from(product);
        //return productService.getProductByID(ID);
    }
}
