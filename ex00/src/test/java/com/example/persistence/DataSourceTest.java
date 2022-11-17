package com.example.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {

    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Test
    public void connectionTest() {
        // try(Statement) : 소괄호 안에 close를 필요로 하는 인스턴스를 작성하게 되면
        // try문이 끝났을 때 자동으로 close()를 실행해준다.
        try (Connection conn = dataSource.getConnection()) {
            log.info(conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
