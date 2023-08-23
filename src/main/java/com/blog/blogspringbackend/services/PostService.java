package com.blog.blogspringbackend.services;

import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer categoryId, Integer userId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    List<PostDto> getAllPosts();
    PostDto getPostById(Integer postId);
    List<PostDto> getPostByCategory(Integer categoryId);
    List<PostDto> getPostByUser(Integer userId);
    List<PostDto> searchPost(String keyword);
}
