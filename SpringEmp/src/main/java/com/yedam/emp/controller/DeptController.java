package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.LocationVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;
import com.yedam.emp.service.impl.LocService;

@Controller
public class DeptController {

	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	@Autowired LocService locService;
	
	// 등록 폼
	/*
	 * @GetMapping("/insertDept") public String insertDept(DeptVO vo, Model model,
	 * EmpSearchVO empvo, JobVO jobvo) { model.addAttribute("empList",
	 * empService.getSearchEmp(empvo)); model.addAttribute("jobList",
	 * jobService.getSearchJob(jobvo)); return "dept/﻿insertDept"; }
	 * 
	 * // 등록처리
	 * 
	 * @PostMapping("/﻿insertDept") public String insertDeptProc(DeptVO vo) {
	 * deptService.insertDept(vo); return "redirect:/getSearchDept"; }
	 */
	
	@GetMapping("/insertDept")
	public String insertDept(DeptVO vo , Model model, EmpSearchVO empvo, LocationVO locvo) {
		model.addAttribute("locList", locService.getSearchLoc(locvo));
		model.addAttribute("empList", empService.getSearchEmp(empvo)); 
		return "dept/deptInsert";
	}
	
	// 수정 폼
	@GetMapping("/updateDept")
	public String updateDept(DeptVO vo, Model model, EmpSearchVO empvo, JobVO jobvo) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		model.addAttribute("empList", empService.getSearchEmp(empvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "dept/﻿updateDept";
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
		return "dept/﻿getDept";
	}
	
	// 검색 조회
	@GetMapping("/getSearchDept")
	public String getSearchDept(DeptSearchVO vo, Paging paging, Model model) {
		// 페이징
		paging.setPageUnit(5);
		paging.setPageSize(3);
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(deptService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "dept/﻿getSearchDept";
	}
}
