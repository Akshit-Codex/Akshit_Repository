package com.example.productservice.Repositories;

import com.example.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Optional<Category> findByName(String category);

    Category save(Category category);
}