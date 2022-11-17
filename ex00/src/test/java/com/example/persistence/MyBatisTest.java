package com.example.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBatisTest {

    @Setter(onMethod_ = @Autowired)
    private SqlSessionFactory factory;

    @Test
    public void connectionTest() {
        try (
                SqlSession sqlSession = factory.openSession(true);
                Connection conn = sqlSession.getConnection();
        ){
            log.info("SqlSession : " + sqlSession);
            log.info("Connection : " + conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
