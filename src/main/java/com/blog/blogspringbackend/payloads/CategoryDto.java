package com.blog.blogspringbackend.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10, message = "title length should be 3-10 char long")
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100, message = "description should be 10-100 chars long")
    private String description;
}
