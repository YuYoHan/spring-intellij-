package com.example.sample;


import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class RestaurantTest {

    @Setter(onMethod_ = @Autowired)
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);
    }
}
