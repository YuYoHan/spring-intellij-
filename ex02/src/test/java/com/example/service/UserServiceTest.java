package com.example.service;

import com.example.domain.UserDTO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTest {
    @Setter(onMethod_ = @Autowired)
    private UserService service;

    @Test
    public void joinTest() {
        UserDTO user = new UserDTO();
        user.setUserId("testId2");
        user.setUserPw("testPw2");
        user.setUserName("김민하");

        log.info("result : " + service.join(user));
    }

    @Test
    public void loginTest() {
        log.info("result : " + service.login("testId2", "testPw2"));
    }
}
