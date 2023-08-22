package com.blog.blogspringbackend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_title",nullable = false,length = 100)
    private String title;

    @Column(name = "post_content", nullable = false)
    private String content;

    @Column(name = "post_image", nullable = false)
    private String image;

    private Date addedDate;
}
