package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repositories.CategoryRepository;
import com.example.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productDbService")
public class ProductDbService implements ProductService
{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductDbService(CategoryRepository categoryRepository, ProductRepository productRepository)
    {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductByID(long ID) throws ProductNotFoundException
    {
        //Here we are demonstrating Query By Method
//        Optional<Category> categoryOptional=categoryRepository.findByName("electronics");
//        List<Product> productList=productRepository.findByCategory(categoryOptional.get());

        // Here we are demonstrating Declarative Queries
        //List<Product> products=productRepository.findByCategory_Name("electronics");

        //Here we are demonstrating JPQL
//        List<Product> products=productRepository.getProductsByCategoryName("electronics");

        //Here we are demonstrating Native Queries
//        List<Product> products=productRepository.getProductsByCategoryNameNative("electronics");
//        System.out.println(products);

        Optional<Product> productOptional = productRepository.findById(ID);

        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with ID "+ ID + " not found");
        }
        return productOptional.get();

    }

    @Override
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String name, double price, String description, String imageUrl, String category)
    {
        Product product = new Product();
        buildProduct(product,name,price,description,imageUrl,category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(long id, String name, double price, String description, String imageUrl, String category)
    {
        Product product = new Product();
        product.setId(id);// If you dont set the ID this will act as create Product,
        // but if you are replacing some product you require ID that's why we are setting ID here.

        buildProduct(product,name,price,description,imageUrl,category);
        return productRepository.save(product);
    }

    private Category getCategoryFromDB(String category)
    {
        Optional<Category> categoryOptional = categoryRepository.findByName(category);
        if(categoryOptional.isPresent())
        {
            return categoryOptional.get();
        }
        Category newCategory = new Category();
        newCategory.setName(category);

        return categoryRepository.save(newCategory);
    }
    private Product buildProduct(Product product,String name, double price, String description, String imageUrl, String category)
    {
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(imageUrl);

        Category categoryObj = getCategoryFromDB(category);

        product.setCategory(categoryObj);
        return product;
    }
}
