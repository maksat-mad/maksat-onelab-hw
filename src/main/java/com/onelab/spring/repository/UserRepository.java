package com.onelab.spring.repository;

import com.onelab.spring.dto.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    public List<User> getAllUsers();
}
