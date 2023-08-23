package com.blog.blogspringbackend.services.impl;

import com.blog.blogspringbackend.entity.Category;
import com.blog.blogspringbackend.entity.Post;
import com.blog.blogspringbackend.entity.User;
import com.blog.blogspringbackend.exceptions.ResourceNotFoundException;
import com.blog.blogspringbackend.payloads.PostDto;
import com.blog.blogspringbackend.repository.CategoryRepo;
import com.blog.blogspringbackend.repository.PostRepo;
import com.blog.blogspringbackend.repository.UserRepo;
import com.blog.blogspringbackend.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        // fetching category and user from the ids to add into the post
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);

        post.setImage("https://placehold.co/600x400");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post createdPost = this.postRepo.save(post);

        return this.modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
         return null;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
