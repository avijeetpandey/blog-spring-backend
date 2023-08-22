package com.blog.blogspringbackend.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotNull
    @NotEmpty
    @Size(min = 4, message = "username should of min 4 characters")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10 , message = "Password must be 3-10 chars long")
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100, message = "About must be 10-100 chars long")
    private String about;
}
