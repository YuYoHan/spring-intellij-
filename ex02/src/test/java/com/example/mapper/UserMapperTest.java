package com.example.mapper;

import com.example.domain.UserDTO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTest {
    @Setter(onMethod_ = @Autowired)
    private UserMapper mapper;

    @Test
    public void joinTest() {
        UserDTO user = new UserDTO();
        user.setUserId("testId");
        user.setUserPw("testPw");
        user.setUserName("testName");

        boolean result = 1 == mapper.join(user);
        log.info("Result : " + result);
    }
}
