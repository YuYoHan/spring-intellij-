package com.example.service;

import com.example.domain.UserDTO;

public interface UserService {
    boolean join(UserDTO user);
    UserDTO login(String userId, String userPw);
}
