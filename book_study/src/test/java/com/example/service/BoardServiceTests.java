package com.example.service;

import com.example.domain.BoardVO;
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
public class BoardServiceTests {
    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test
    public void existTest() {
        log.info(service);
    }

    @Test
    public void  resisterTest() {
        BoardVO board = new BoardVO();
        board.setBoardTitle("새로 작성한 글");
        board.setBoardContents("새로 작성한 내용");
        board.setUserId("user00");

        service.register(board);
        log.info("생성된 게시글의 번호 : " + board.getBoardNum());
    }

    @Test
    public void  testGetList() {
        service.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testGet() {
        log.info(service.get(1L));
    }

}
