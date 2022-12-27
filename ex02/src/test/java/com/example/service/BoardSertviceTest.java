package com.example.service;

import com.example.domain.BoardDTO;
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
public class BoardSertviceTest {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test
    public void listTest() {
        log.info(service.getList());
    }

    @Test
    public void insertTest() {
        BoardDTO board = new BoardDTO();
        board.setBoardNum(1L);
        board.setBoardTitle("zxzz45");
        board.setBoardContents("테스트중입니다.");
        board.setUserId("zxzz45");
        board.setRegDate("2022-12-27");
        board.setUpdateDate("2022-12-27");

        log.info(board);
    }

    @Test
    public void getMaxBoardNumTest() {
        log.info(service.getMaxBoardNum("apple"));
    }
}
