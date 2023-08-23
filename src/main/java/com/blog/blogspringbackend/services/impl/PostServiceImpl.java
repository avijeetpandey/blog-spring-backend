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
    public Post createPost(PostDto postDto, Integer categoryId, Integer userId) {
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
        
        return this.postRepo.save(post);
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
