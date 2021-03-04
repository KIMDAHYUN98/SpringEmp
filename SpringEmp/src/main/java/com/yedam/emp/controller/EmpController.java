package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;
// 컨트롤러가 관리하도록 빈 등록하기
@Controller
public class EmpController {

	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;

	@RequestMapping("/") // get, post 구분 안 할 때 사용, 등록페이지로 이동
	public String main() {
		return "main"; // servlet 설정할 때 Web-inf/views/main.jsp
	}

	@GetMapping("/insertEmp") // 등록 폼
	public String insertEmp(EmpVO vo, Model model, DeptSearchVO deptvo, JobVO jobvo) { // 자동으로 모델에 저장된다.
		//deptvo.setStart(1);
		//deptvo.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/insertEmp";
	}

	@PostMapping("/insertEmp") // 등록 처리(등록버튼을 누르면 모든 파라미터 값이 자동으로 vo에 담긴다)
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp"; // 목록으로 이동
	}
	
	@GetMapping("/updateEmp") // 수정 폼
	public String updateEmp(EmpVO vo, Model model, DeptSearchVO deptvo, JobVO jobvo) { //empVO
		model.addAttribute("empVO", empService.getEmp(vo));
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/UpdateEmp";
	}

	@PostMapping("/updateEmp") // 수정 처리 
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@RequestMapping("/deleteEmp") // 삭제
	public String deleteEmp(EmpVO vo) {
		empService.DeleteEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/getEmp") // 단건 조회
	public String getEmp( Model model
						//, HttpServletRequest request)
						//, @RequestParam(value="id", 
						//				required = false, // 아이디가 없다면 초기값으로 100을 넘겨라 
						//				defaultValue = "100") String employee_id 
			
						// pathVariable 방법
						//, @PathVariable String employee_id
						  , @ModelAttribute("employee") EmpVO vo // 스프링이 자동으로 메서드 부를 떄 커맨드 객체(model에 add)를 읽고 파라미터를 받아서 생성한다.
						) {
		// 1. getParameter 방식(기존에 사용했던 방법)
		  //String employee_id = request.getParameter("employee_id");
		  //EmpVO vo = new EmpVO();
		 // vo.setEmployee_id(employee_id);

		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}

	@GetMapping("/getSearchEmp") // 전체 검색( 조회, 검색 등 여러 메소드 생성 가능)
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		// 페이징
		paging.setPageUnit(5); // 한 페이지에 출력되는 레코드 건수가 5개
		paging.setPageSize(3); // 페이지 번호수 3개
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}
}
