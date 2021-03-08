package com.yedam.emp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Controller
public class LoginController {

	//@Resource
	
	@Autowired UserService userService;
	
	// 로그인 페이지 이동
	@GetMapping("/login")
	public String login() { 
 		return "user/login";
	}
	
	// 로그인 처리
	@PostMapping("/login")
	public String loginProc(UserVO vo, HttpSession session) {
		// boolean 값으로 리턴
		if(userService.loginCheck(vo)) {							// 로그인 성공
			session.setAttribute("loginId", vo.getId()); 			// vo에 있는 아이디 값을 session에 저장			
			// Session에 저장
			return "redirect:/";
		} else { 													// 로그인 실패
			return "user/login";
		}
	}
	
	// 로그아웃 처리
	@GetMapping("/logout")
	public String logout(UserVO vo, HttpSession session) {
		session.invalidate();										// 섹션 무효화(다음 접속 때 새로운 색션이 생성될 것이다.)
		return "redirect:/"; // / == root(최상위 루트 : main.jsp)
	}
	
	// 패스워드 변경 페이지 이동
	@GetMapping("/changePw")
	public String changePw() {
		return "user/changePw";
	}
	
	// 패스워드 변경 처리
	@PostMapping("/changePw")
	public String changePwProc(UserVO vo, HttpSession session) { // p.367
		// 1. validation 일치 여부 확인 (생략가능), user
		// 2. 패스워드 변경 서비스
		String id = (String) session.getAttribute("loginId"); 		// 섹션에 있는 아이디가 이용해서 조회
		vo.setId(id); 												// id의 값을 vo 에 담아서 단건 조회
		if(vo.getNewpassword().equals(vo.getPassword())) {
			userService.updatePw(vo);
		}
		return "redirect:/";
		// 3. update Service 호출
	}
}
