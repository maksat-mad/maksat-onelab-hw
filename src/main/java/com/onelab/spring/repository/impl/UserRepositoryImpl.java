package com.onelab.spring.repository.impl;

import com.onelab.spring.dto.User;
import com.onelab.spring.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> userList;

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
