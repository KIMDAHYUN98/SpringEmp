package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Controller
public class JobController {

	@Autowired
	JobService jobService;
	
	@GetMapping("/insertJob")
	public String insertJob(JobVO vo) {
		return "/job/insertJob";
	}
	
	@PostMapping("/insertJob")
	public String insertJobProc(JobVO vo) {
		return "redirect:/getSearchJob";
	}
	
	@GetMapping("/updateJob")
	public String updateJob(JobVO vo, Model model) {
		model.addAttribute("jobVO", jobService.getJob(vo));
		return "/job/updateJob";
	}
	
	@PostMapping("/updateJob")
	public String updateJobProc(JobVO vo) {
		jobService.updateJob(vo);
		return "redirect:/getSearchJob";
	}
	
	@RequestMapping("/deleteJob")
	public String deleteJob(JobVO vo) {
		jobService.deleteJob(vo);
		return "redirect:/getSearchJob";
	}
	
	@GetMapping("/getJob")
	public String getJob(JobVO vo, Model model) {
		model.addAttribute("job", jobService.getJob(vo));
		return "/job/getJob";
	}
	
	@GetMapping("/getSearchJob")
	public String getSearchJob(JobVO vo, Model model) {
		model.addAttribute("list", jobService.getSearchJob(vo));
		return "/job/getSearchJob";
	}
}
