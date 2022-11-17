package com.example.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
 * spring-test 모듈을 이용해서 간단하게 스프링을 가동시키고 스프링 동작을 활성화한다.
 * 반드시 Junit 4.10이상 버전을 사용
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
    @Setter(onMethod_ = @Autowired)
    private TimeMapper mapper1;

    // JUnit에서 테스트 대상임을 표시
    @Test
    public void getTimeTest() {
        log.info("Now: " + mapper1.getTime());
    }
}
