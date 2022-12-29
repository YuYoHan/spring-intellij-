package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.domain.PageDTO;
import com.koreait.service.BoardService;

import lombok.Setter;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(service.count(cri), cri));
	}
	@GetMapping("/regist")
	public void regist() {
		
	}
	@PostMapping("/regist")
	public String regist(BoardDTO board, RedirectAttributes ra) {
		service.regist(board);
		int boardnum = service.getMaxBoardnum(board.getUserid());
		ra.addFlashAttribute("boardnum", boardnum);
		return "redirect:/board/list";
	}
	
	@GetMapping(value = {"/get", "/modify"})
	public void get(Long boardnum, @ModelAttribute("cri") Criteria cri, Model model) {
		//@ModelAttribute("키값") : 데이터를 수집하자 마자 해당하는 키값으로 Model에 attribute로 추가
		model.addAttribute("board", service.get(boardnum));
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO board, Criteria cri, RedirectAttributes ra) {
		if(service.modify(board)) {
			ra.addFlashAttribute("mn",board.getBoardnum());
		}
		return "redirect:/board/get"+cri.getListLink()+"&boardnum="+board.getBoardnum();
	}
	
	@PostMapping("/remove")
	public String remove(Long boardnum,Criteria cri) {
		if(service.remove(boardnum)) {
			//
		}
		return "redirect:/board/list"+cri.getListLink();
	}
}








