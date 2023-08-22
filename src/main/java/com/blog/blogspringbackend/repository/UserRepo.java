package com.blog.blogspringbackend.repository;

import com.blog.blogspringbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
