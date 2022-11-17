package com.example.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
/*
 * spring-test 모듈을 이용해서 간단하게 스프링을 가동시키고 스프링 동작을 활성화한다.
 * 반드시 Junit 4.10이상 버전을 사용
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class HotelTest {
	@Setter(onMethod_ = @Autowired)
	private Hotel hotel;

	// JUnit에서 테스트 대상임을 표시
	@Test
	public void testExist() {
		// 무엇인가 잘 담겨있으면 통과
		// hotel 객체가 null이 아니여야만 테스트를 통과하는 것이다.
		assertNotNull(hotel);
		System.out.println(hotel);
		System.out.println(hotel.getChef());
	}
	// 1. 테스트코드가 실행되기 위해서 스프링 프레임워크가 동작
	// 2. 동작되는 과정에서 필요한 객체들이 스프링에 등록
	// 3. 의존성 주입이 필요한 객체는 자동으로 주입이 이루어짐
} 
