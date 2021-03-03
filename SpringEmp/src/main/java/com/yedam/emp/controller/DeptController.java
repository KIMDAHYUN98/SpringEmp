package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;
	
	// 등록 폼
	@GetMapping("/insertDept")
	public String insertDept(DeptVO vo) {
		return "/dept/insertDept";
	}
	
	// 등록처리
	@PostMapping("/insertDept")
	public String insertDeptProc(DeptVO vo) {
		deptService.insertDept(vo);
		return "redirect:/getSearchDept"; 
	}
	
	// 수정 폼
	@GetMapping("/updateDept")
	public String updateDept(DeptVO vo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		return "/dept/updateDept";
	}
	
	// 수정처리
	@PostMapping("/updateDept")
	public String updateDeptProc(DeptVO vo) {
		deptService.updateDept(vo);
		return "redirect:/getSearchDept"; 
	}
	
	// 삭제
	@RequestMapping("/deleteDept")
	public String deleteDept(DeptVO vo) {
		deptService.deleteDept(vo);
		return "redirect:/getSearchDept";
	}
	
	// 단건 조회
	@GetMapping("/getDept")
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptService.getDept(vo));
		return "/dept/﻿getDept";
	}
	
	// 검색 조회
	@GetMapping("/getSearchDept")
	public String getSearchDept(DeptVO vo, Model model) {
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/﻿getSearchDept";
	}
}
