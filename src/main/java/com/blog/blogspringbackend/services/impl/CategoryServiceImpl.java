package com.blog.blogspringbackend.services.impl;

import com.blog.blogspringbackend.entity.Category;
import com.blog.blogspringbackend.entity.User;
import com.blog.blogspringbackend.exceptions.ResourceNotFoundException;
import com.blog.blogspringbackend.payloads.CategoryDto;
import com.blog.blogspringbackend.repository.CategoryRepo;
import com.blog.blogspringbackend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> savedCategories = this.categoryRepo.findAll();
        return savedCategories.stream().map(this::categoryToDto).toList();
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category","id",categoryId));

        return this.categoryToDto(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category","id",categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category","id",categoryId));

        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());

        Category savedCategory = categoryRepo.save(category);

        return categoryToDto(savedCategory);
    }

    Category dToCategory(CategoryDto categoryDto) {
        return this.modelMapper.map(categoryDto, Category.class);
    }

    CategoryDto categoryToDto(Category category) {
        return  this.modelMapper.map(category, CategoryDto.class);
    }
}
