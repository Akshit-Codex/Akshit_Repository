package com.example.productservice.Controllers;

import com.example.productservice.DTOs.CreateFakeStoreProductRequestDTO;
import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest
{
    @MockitoBean
    @Qualifier("productDBService")
    ProductService productService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Product getProductForTest()
    {
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
        return dummyProduct;
    }

    @Test
    public void testGetAllProductsRunSuccessfully() throws Exception
    {
        //Arrange
        Product dummyProduct1 = getProductForTest();
        Product dummyProduct2 = getProductForTest();
        dummyProduct2.setId(2L);
        List<Product> dummyProducts = List.of(dummyProduct1, dummyProduct2);

        List<ProductResponseDTO> dummyProductResponseDtos =List.of(
                ProductResponseDTO.from(dummyProduct1),ProductResponseDTO.from(dummyProduct2));

        when(productService.getAllProducts()).thenReturn(dummyProducts);

        //Act and Assert
        mockMvc.perform(get("/product"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))// this part is optional
                .andExpect(content().string(objectMapper.writeValueAsString(dummyProductResponseDtos)));
    }

    @Test
    public void testCreateProductsRunsSuccessfully() throws Exception
    {
        CreateFakeStoreProductRequestDTO dummyRequestDto = new CreateFakeStoreProductRequestDTO();
        dummyRequestDto.setName("IPhone16");
        dummyRequestDto.setDescription("Product 1");
        dummyRequestDto.setPrice(12.8);
        dummyRequestDto.setImageUrl("img.UrlDummy");
        dummyRequestDto.setCategory("Category 1");

        Product productAfterSave = getProductForTest();
        ProductResponseDTO productResponseDTO = ProductResponseDTO.from(productAfterSave);

        when(productService.createProduct(dummyRequestDto.getName(),dummyRequestDto.getPrice(),
                dummyRequestDto.getDescription(),dummyRequestDto.getImageUrl(),
                dummyRequestDto.getCategory())).thenReturn(productAfterSave);

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dummyRequestDto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(productResponseDTO)));
    }

}
