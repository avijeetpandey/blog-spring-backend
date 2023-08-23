package com.blog.blogspringbackend.repository;

import com.blog.blogspringbackend.entity.Category;
import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.entity.User;
import com.blog.blogspringbackend.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostDto, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
