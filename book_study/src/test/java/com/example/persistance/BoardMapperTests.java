package com.example.persistance;

import com.example.domain.BoardVO;
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
    public void getListTest() {
//        log.info(mapper.getList());
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void  insertTest() {
        BoardVO board = new BoardVO();
        board.setBoardTitle("새로 작성한 글");
        board.setBoardContents("새로 작성한 내용");
        board.setUserId("user00");

        mapper.insert(board);
        log.info(board);
    }

//    @Test
//    public void InsertSelectKey() {
//        BoardVO board = new BoardVO();
//        board.setBoardTitle("새로 작성한 글 select key");
//        board.setBoardContents("새로 작성한 내용 select key");
//        board.setUserId("user00");
//
//        mapper.insertSelectKey(board);
//        log.info(board);
//    }

    @Test
    public void  readTest() {
        BoardVO board = mapper.read(5L);
        log.info(board);
    }

    @Test
    public void  deleteTest() {
        log.info("delete count : " + mapper.delete(3L));
    }

    @Test
    public void updateTest() {
        BoardVO board = new BoardVO();

        // 실행전 존재하는 번호인지 확인할 것
        board.setBoardNum(5L);
        board.setBoardTitle("수정된 제목");
        board.setBoardContents("수정된 내용");
        board.setUserId("user01");

        int count = mapper.update(board);
        log.info("update count : " + count);
    }
}
