package com.example.productservice.Controllers;

import com.example.productservice.DTOs.CreateFakeStoreProductRequestDTO;
import com.example.productservice.DTOs.ErrorDTO;
import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController
{
    ProductService productService;
    public ProductController(
            @Qualifier("productDbService") ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/product/{ID}")
    public ProductResponseDTO getProductByID(@PathVariable long ID) throws ProductNotFoundException
    {
        Product product=productService.getProductByID(ID);

        return ProductResponseDTO.from(product);
        //return productService.getProductByID(ID);
    }

    @GetMapping("/product")
    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> products=productService.getAllProducts();

        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
        for(Product product:products)
        {
            ProductResponseDTO productResponseDTO=ProductResponseDTO.from(product);
            productResponseDTOS.add(productResponseDTO);
        }
        return productResponseDTOS;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody CreateFakeStoreProductRequestDTO createFakeStoreProductRequestDTO)
    {
        Product product=productService.createProduct(
                createFakeStoreProductRequestDTO.getName(),
                createFakeStoreProductRequestDTO.getPrice(),
                createFakeStoreProductRequestDTO.getDescription(),
                createFakeStoreProductRequestDTO.getImageUrl(),
                createFakeStoreProductRequestDTO.getCategory());
        return new ResponseEntity<>(ProductResponseDTO.from(product), HttpStatus.CREATED);
    }

    @PutMapping("/product/{ID}")
    public ProductResponseDTO replaceProduct(@PathVariable long ID,
                                             @RequestBody CreateFakeStoreProductRequestDTO
                                                     createFakeStoreProductRequestDTO)
    {
        Product product=productService.replaceProduct(
                ID,
                createFakeStoreProductRequestDTO.getName(),
                createFakeStoreProductRequestDTO.getPrice(),
                createFakeStoreProductRequestDTO.getDescription(),
                createFakeStoreProductRequestDTO.getImageUrl(),
                createFakeStoreProductRequestDTO.getCategory());
        return ProductResponseDTO.from(product);
    }
}
