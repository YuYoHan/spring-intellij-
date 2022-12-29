package com.example.persistance;

import com.example.mapper.BoardMapper;
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
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void GetListTest() {
//        log.info(mapper.getList());
        mapper.getList().forEach(board -> log.info(board));
    }
}
