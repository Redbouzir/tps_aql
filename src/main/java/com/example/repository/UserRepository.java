package com.example.repository;

import com.example.model.User;

public interface UserRepository {
    User findUserById(long id);
} 