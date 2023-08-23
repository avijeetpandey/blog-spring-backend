package com.blog.blogspringbackend.payloads;


import com.blog.blogspringbackend.entity.Category;
import com.blog.blogspringbackend.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 10, max = 200, message = "Post title can be 10-200 chars long ")
    private String title;

    @NotNull(message = "post content cannot be null")
    @NotBlank(message = "post content cannot be blank")
    @NotEmpty(message = "post content cannot be empty")
    @Size(min = 10, max = 2000, message = "Post content can be 10-2000 chars long ")
    private String content;

    @NotNull
    @NotEmpty(message = "post image cannot be null")
    private String image;

    private Date addedDate;

    @NotNull
    @NotEmpty(message = "category cannot be empty")
    private Category category;

    @NotNull
    @NotEmpty
    private User user;
}
