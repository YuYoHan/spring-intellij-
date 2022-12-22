package com.example.controller;

import com.example.domain.UserDTO;
import com.example.service.UserService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(
        {
                "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
                "file:src/main/webapp/WEB-INF/spring/root-context.xml"
        })
// Spring Framework에서 애플리케이션 컨텍스트의 웹 버전을 생성하는 데 사용되는 클래스 레벨 어노테이션입니다.
@WebAppConfiguration
public class UserControllerTest {
    @Setter(onMethod_ = @Autowired)
    private WebApplicationContext wac;
    // web 관련된 spring MVC가 필요한데 그걸 실행하려면 서버를 실행해야 한다.
    // 테스트할때는 서버를 실행하지 않기 때문에 MockMvc라는 것이 필요하다.
    // 테스트를 위해 브라우저나 WAS의 동작을 똑같이 처리해줄 수 있는 환경이다.
    // 가짜 MVC
    // 마치 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해볼 수 있습니다.
    private MockMvc mvc;

    // org.junit.Before
    // 적용된 메소드들을 모든 테스트 전에 한번씩 실행한다.
    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void joinTest() throws Exception {
        // perform 안에다가 어떤 요청을 만들어서 넘겨주면 mvc가 행동을 한다.
        // perform은 가상의 요청을 처리한다.
        // MockMvcRequestBuilders.get("/user/join") : /user/join get방식 요청을 보내는 자체
        // .andReturn() : 요청에 대한 결과 즉, 응답이다. 뷰나 모델을 포함하고 있다.
        ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/user/join"))
                .andReturn()
                .getModelAndView();

        // 어떤 뷰를 찾아갈건지
        log.info(mav.getViewName());
        // 어떤 모델에 어떤 데이터들이 담겨있는지 확인할 수 있다.
        log.info(mav.getModelMap());
    }

    @Test
    public void loginTest() throws  Exception {
        ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/user/login")
                .param("userId", "apple")
                .param("userPw", "zxzz12")
        ).andReturn()
                .getModelAndView();

        // 어떤 뷰를 찾아갈건지
        log.info(mav.getViewName());
        // 어떤 모델에 어떤 데이터들이 담겨있는지 확인할 수 있다.
        log.info(mav.getModelMap());
    }

    @Test
    public void joinTest2() throws Exception {
        ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/user/join")
                .param("userId", "bananasd")
                .param("userPw", "zxzz12")
                .param("userName", "바나나")
        ).andReturn().getModelAndView();

        log.info(mav.getViewName());
        log.info(mav.getModelMap());
    }
}
