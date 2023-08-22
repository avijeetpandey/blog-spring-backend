package com.blog.blogspringbackend.repository;

import com.blog.blogspringbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
