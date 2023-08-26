package com.blog.blogspringbackend.controllers;

import com.blog.blogspringbackend.payloads.ApiResponse;
import com.blog.blogspringbackend.payloads.CategoryDto;
import com.blog.blogspringbackend.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Mapping to create a category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategoryDto, HttpStatus.OK);
    }

    // Mapping to get a category
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable String categoryId) {
        return new ResponseEntity<>(this.categoryService.getCategoryById(Integer.parseInt(categoryId)),
                HttpStatus.OK);
    }

    // Mapping to update a category
    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable String categoryId,
                                                      @RequestBody CategoryDto categoryDto) {
        try {
            CategoryDto savedCategory = this.categoryService.getCategoryById(Integer.parseInt(categoryId));
            this.categoryService.updateCategory(savedCategory, Integer.parseInt(categoryId));
            ApiResponse apiResponse = new ApiResponse("category updated successfully", false);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("unable to update category", true);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mapping to delete a category
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable String categoryId) {
        try {
            this.categoryService.deleteCategory(Integer.parseInt(categoryId));
            ApiResponse apiResponse = new ApiResponse("category deleted successfully", false);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (Exception ex) {
            ApiResponse apiResponse = new ApiResponse("unable to delete category", true);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Mapping to get all categories
    @GetMapping("/")
    public List<CategoryDto> getAllCategories() {
        return this.categoryService.getAllCategories();
    }
}
