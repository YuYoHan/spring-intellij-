package com.example.controller;

import com.example.domain.BoardDTO;
import com.example.domain.Criteria;
import com.example.domain.PageDTO;
import com.example.service.BoardService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        model.addAttribute("list", service.getList());
        model.addAttribute("pageMaker", new PageDTO(service.count(cri), cri));
    }

    @GetMapping("/regist")
    public void regist() {

    }
    @PostMapping("/regist")
    // Model model도 request로 넘겨주는 것이라
    // redirect면 다 날라간다.
    // 이럴때 RedirectAttributes 매개변수를 사용한다.
    public String reggist(BoardDTO board, RedirectAttributes ra) {
        service.regist(board);
        int boardNum = service.getMaxBoardNum(board.getUserId());
        ra.addFlashAttribute("boardNum", boardNum);
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(Long boardNum, Model model) {
        model.addAttribute("board", service.get(boardNum));
    }
}
