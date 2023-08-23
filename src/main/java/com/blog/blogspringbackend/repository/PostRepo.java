package com.blog.blogspringbackend.repository;

import com.blog.blogspringbackend.entity.Category;
import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
