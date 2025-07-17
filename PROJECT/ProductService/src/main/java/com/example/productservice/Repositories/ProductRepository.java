package com.example.productservice.Repositories;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/*
1st Argument: Entity name for the repository
2nd Argument: Type of the primary key
* */
public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product save(Product product);

    Optional<Product> findById(long id);

    List<Product> findAll();

    List<Product> findByCategory(Category category);//Query By Method

    List<Product> findByCategory_Name(String name); // Declarative Queries

    @Query("select p from Product p where p.category.name=:categoryName")// JPQL(Jakarta Persistence Query Language)
    List<Product> getProductsByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = CustomQuery.GET_PRODUCT_FROM_CATEGORY_NAME,nativeQuery = true) // Native Queries
    List<Product> getProductsByCategoryNameNative(@Param("categoryName") String categoryName);
}
