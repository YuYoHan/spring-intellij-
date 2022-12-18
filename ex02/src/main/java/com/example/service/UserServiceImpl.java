package com.example.service;

import com.example.domain.UserDTO;
import com.example.mapper.UserMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class UserServiceImpl implements UserService {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    @Override
    public boolean join(UserDTO user) {
        return mapper.join(user) == 1;
    }

    @Override
    public UserDTO login(String userId, String userPw) {
        UserDTO loginUser = mapper.login(userId, userPw);
        return loginUser;
    }
}









