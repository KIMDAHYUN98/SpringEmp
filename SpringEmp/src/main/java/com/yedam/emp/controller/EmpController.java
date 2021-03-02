package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
// controller
@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	@RequestMapping("/") // get, post 구분 안 할 때 사용
	public String main() {
		return "main"; // servlet 설정할 때 Web-inf/views/main.jsp
	}

	@GetMapping("/insertEmp") // 등록 폼
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}

	@PostMapping("/insertEmp") // 등록 처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/updateEmp") // 수정 폼
	public String updateEmp(EmpVO vo) {
		return "/emp/UpdateEmp";
	}

	@PostMapping("/updateEmp") // 수정 처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/getEmp") // 단건 조회
	public String getEmp(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}

	@GetMapping("/getSearchEmp") // 전체 검색
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}
}
