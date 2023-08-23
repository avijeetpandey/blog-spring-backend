package com.blog.blogspringbackend.controllers;

import com.blog.blogspringbackend.payloads.PostDto;
import com.blog.blogspringbackend.services.PostService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/{postId}")
    public ResponseEntity<HttpStatus> updatePost(@PathVariable String postId,
                                                 @RequestBody PostDto postDto) {
        try {
            this.postService.updatePost(postDto,Integer.parseInt(postId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Mapping to delete post
    @DeleteMapping("/{postId}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable String postId) {
        try {
            this.postService.deletePost(Integer.parseInt(postId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Mapping to fetch one post
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable String postId) {
        PostDto postDto = this.postService.getPostById(Integer.parseInt(postId));
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    // Mapping to fetch post by a user
    @GetMapping("/u/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable String userId) {
       List<PostDto> postsByUser = this.postService.getPostByUser(Integer.parseInt(userId));
        return new ResponseEntity<>(postsByUser,HttpStatus.OK);
    }

    // Mapping to fetch post by a category
    @GetMapping("/c/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable String categoryId) {
        List<PostDto> postsByCategory = this.postService.getPostByCategory(Integer.parseInt(categoryId));
        return new ResponseEntity<>(postsByCategory,HttpStatus.OK);
    }

    // Mapping to get all the posts
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                     @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        List<PostDto> allPosts = this.postService.getAllPosts(pageNumber,pageSize);
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
}
