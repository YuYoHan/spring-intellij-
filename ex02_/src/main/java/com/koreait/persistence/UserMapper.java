package com.koreait.persistence;

import com.koreait.domain.UserDTO;

public interface UserMapper {
    int join(UserDTO user);

}
