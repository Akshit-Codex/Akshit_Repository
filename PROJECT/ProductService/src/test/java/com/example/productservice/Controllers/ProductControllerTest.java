package com.example.productservice.Controllers;

import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest
{
    @MockitoBean
    @Qualifier("productDBService")
    ProductService productService;

    @Autowired
    ProductController productController;

    @Test
    public void testGetProductByIdReturnsDTO() throws ProductNotFoundException
    {
        //Arrange
        Product dummyProduct = new Product();

        dummyProduct.setId(1L);
        dummyProduct.setName("IPhone16");
        dummyProduct.setDescription("Product 1");
        dummyProduct.setImageURL("img.UrlDummy");
        dummyProduct.setPrice(12.8);

        Category dummyCategory = new Category();
        dummyCategory.setId(1L);
        dummyCategory.setName("Category 1");

        dummyProduct.setCategory(dummyCategory);
        when(productService.getProductByID(1L)).thenReturn(dummyProduct);

        //Act
        ProductResponseDTO productResponseDTO=productController.getProductByID(1L);

        //Assert
        assertEquals(dummyProduct.getId(),productResponseDTO.getID());
        assertEquals(dummyProduct.getName(),productResponseDTO.getName());
        assertEquals(dummyProduct.getDescription(),productResponseDTO.getDescription());
        assertEquals(dummyProduct.getImageURL(),productResponseDTO.getImage());
        assertEquals(dummyProduct.getPrice(),productResponseDTO.getPrice());
        assertEquals(dummyProduct.getCategory().getName(),productResponseDTO.getCategory());
    }

    @Test
    public void testGetProductByIdReturnsNull() throws ProductNotFoundException
    {
        //Arrange
        when(productService.getProductByID(1L)).thenReturn(null);

        //Act
        ProductResponseDTO productResponseDTO=productController.getProductByID(1L);

        assertNull(productResponseDTO);// you can also write assertEquals(null,productResponseDTO)
        //assertEquals(null,productResponseDTO);
    }
}