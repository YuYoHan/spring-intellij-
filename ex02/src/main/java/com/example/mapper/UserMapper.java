package com.example.mapper;

import com.example.domain.UserDTO;

public interface UserMapper {
    int join(UserDTO user);
    UserDTO login(String userId, String userPw);
}
