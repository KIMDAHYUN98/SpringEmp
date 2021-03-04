package com.yedam.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.OrderMasterVO;

@Controller
public class OrederController {
	
	@GetMapping("/insertOrder") // 주문 폼으로
	public String insertOrder(OrderMasterVO vo) {
		System.out.println(vo);
		return "order/insertOrder";
	}
	
	@PostMapping("/insertOrder") // 주문 처리
	public String insertOrderProc(OrderMasterVO vo) {
		System.out.println(vo);
		// master 테이블 등록
		// detail(주문상세) 는 list 갯수만큼 for문 돌아서 등록
		return "redirect:/";
	}
}
