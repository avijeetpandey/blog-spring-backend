package com.blog.blogspringbackend.services;

import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.payloads.PostDto;

import java.util.List;

public interface PostService {
    Post createPost(PostDto postDto);
    Post updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    List<Post> getPostByCategory(Integer categoryId);
    List<Post> getPostByUser(Integer userId);
    List<Post> searchPost(String keyword);
}
