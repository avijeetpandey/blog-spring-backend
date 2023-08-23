package com.blog.blogspringbackend.services.impl;

import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.payloads.PostDto;
import com.blog.blogspringbackend.services.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public Post createPost(PostDto postDto) {
        return null;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
