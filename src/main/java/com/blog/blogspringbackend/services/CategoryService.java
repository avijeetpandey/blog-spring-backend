package com.blog.blogspringbackend.services;

import com.blog.blogspringbackend.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategoryById(Integer categoryId);
    public void deleteCategory(Integer categoryId);
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
}
