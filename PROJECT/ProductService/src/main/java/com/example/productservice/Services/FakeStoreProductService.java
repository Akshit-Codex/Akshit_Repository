package com.example.productservice.Services;

import com.example.productservice.DTOs.FakeStoreRequestDTO;
import com.example.productservice.DTOs.FakeStoreResponseDTO;
import com.example.productservice.DTOs.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import org.springframework.http.*;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.events.Event;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService
{
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductByID(long ID) throws ProductNotFoundException
    {
        FakeStoreResponseDTO fakeStoreResponseDTO=restTemplate.
                getForObject("https://fakestoreapi.com/products/" + ID,
                        FakeStoreResponseDTO.class);
        if(fakeStoreResponseDTO==null)
        {
            throw new ProductNotFoundException("Product with ID "+ID+" is not found");
        }
        return fakeStoreResponseDTO.toProduct();
    }

    public List<Product> getAllProducts()
    {
        FakeStoreResponseDTO[] fakeStoreResponseDTOS=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreResponseDTO[].class);
        List<Product> list=new ArrayList<>();
        for(FakeStoreResponseDTO fakeStoreResponseDTO: fakeStoreResponseDTOS)
        {
            Product product=fakeStoreResponseDTO.toProduct();
            list.add(product);
        }
        return list;
    }

    @Override
    public Product createProduct(String name, double price, String description, String imageUrl, String category)
    {
        FakeStoreRequestDTO fakeStoreRequestDTO=createDTOFromParams(name,price,description,imageUrl,category);
        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreRequestDTO,FakeStoreResponseDTO.class);

        return fakeStoreResponseDTO.toProduct();
    }

    public FakeStoreRequestDTO createDTOFromParams(String name, double price, String description, String imageUrl, String category)
    {
        FakeStoreRequestDTO fakeStoreRequestDTO=new FakeStoreRequestDTO();
        fakeStoreRequestDTO.setTitle(name);
        fakeStoreRequestDTO.setPrice(price);
        fakeStoreRequestDTO.setDescription(description);
        fakeStoreRequestDTO.setImage(imageUrl);
        fakeStoreRequestDTO.setCategory(category);
        return fakeStoreRequestDTO;
    }

    @Override
    public Product replaceProduct(long id, String name, double price, String description, String imageUrl, String category)
    {
        FakeStoreRequestDTO updatedFakeStoreRequestDTO=createDTOFromParams(name,price,description,imageUrl,category);

//        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.put("https://fakestoreapi.com/products/"+id,
//                fakeStoreRequestDTO,FakeStoreResponseDTO.class);
// Put does not work for this API as it returns void
// so we are going to use exchange method along with HTTP Entity instead of ResponseEntity

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<FakeStoreRequestDTO> requestEntity=
                new HttpEntity<>(updatedFakeStoreRequestDTO,headers);
        ResponseEntity<FakeStoreResponseDTO> responseEntity=restTemplate.exchange("https://fakestoreapi.com/products/"+ id,
                HttpMethod.PUT,
                requestEntity,
                FakeStoreResponseDTO.class);

        return responseEntity.getBody().toProduct();
    }
}
