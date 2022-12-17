package com.example.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

// 스프링을 실행하는 역할을 할 것이라는 것을 @Runwith 어노테이션으로 표시
@RunWith(SpringJUnit4ClassRunner.class)
// 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에서 객체로 등록하게 됩니다.
// 흔히 스프링의 빈으로 등록된다고 표현합니다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    // JUnit에서 테스트 대상을 표시하는 어노테이션
    @Test
    public void testExist() {
        // restaurant 변수가 null이 아니어야만 테스트가 성공한다는 것을 의미한다.
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("-----------------------");
        log.info(restaurant.getChef());
    }
}
