package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/user")
	public UserVO inserUser(@RequestBody UserVO vo) {
		userService.insertUser(vo);
		if(vo.getId().equals("0")) {
			return vo;
		} else {
		return userService.getUser(vo);
		}
	}
	
	@PutMapping("/user")
	public UserVO updateUser(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	
	@DeleteMapping(value = "/user")
	public Map deleteUser(@RequestBody UserVO vo) {
		int r = userService.deletetUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	@GetMapping("/user")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}
	
	@GetMapping("/user/{id}")
	public UserVO getUser(UserVO vo, @PathVariable String id) {
		vo.setId(id);
		return userService.getUser(vo);
		
	}
	
}
