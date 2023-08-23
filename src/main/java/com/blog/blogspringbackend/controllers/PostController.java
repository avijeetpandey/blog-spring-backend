package com.blog.blogspringbackend.controllers;

import com.blog.blogspringbackend.payloads.PostDto;
import com.blog.blogspringbackend.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;

    // Mapping to create post
    @PostMapping("/u/{userId}/c/{categoryId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable String userId,
                                              @PathVariable String categoryId) {

        PostDto createdPost =  this.postService.createPost(postDto,
                                                            Integer.parseInt(userId),
                                                            Integer.parseInt(categoryId));
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
    // Mapping to update post
    // Mapping to delete post
    // Mapping to fetch one post
    // Mapping to fetch post by a user
    // Mapping to fetch post by a category
}
