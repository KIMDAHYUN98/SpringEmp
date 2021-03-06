package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

// 일반 http 요청 방식, 모든 요청 데이터는 vo에 담는다.

@RestController
public class UserController {
	@Autowired UserService userService;
	
	// 등록
	@PostMapping("/insertUser")
	public ResponseEntity<Object> inserUser(UserVO vo) throws JsonProcessingException { 
		userService.insertUser(vo);
		UserVO userVO = userService.getUser(vo);
		if(userVO != null) { 
			ObjectMapper mapper = new ObjectMapper(); // jackson 라이브러리 json
			return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO));
		} else {
			// userVO에 등록되지 않았을 때
			return ResponseEntity.status(500).body(" insert error "); 
			//userService.getUser(vo);
		}
		
	}
	
	// 수정
	@PostMapping("/updateUser")
	public UserVO updateUser(UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}
	
	/*
	 * @DeleteMapping("/user/{id}") 
	 * public Map deleteUser(UserVO vo, @PathVariable
	 * String id) { vo.setId(id); int r = userService.deletetUser(vo); return
	 * Collections.singletonMap("cnt", r); 
	 * }
	 */
	
	@GetMapping(value="/deleteUser")
    public Map deleteUser(UserVO vo) { // 커맨드 객체로 담음
      int r = userService.deletetUser(vo); 
      return Collections.singletonMap("cnt", r); // 삭제 되었으면 1, 아니면 0
   }
	
	// 전체 조회
	@GetMapping("/getUserList")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}
	
	// 단건 조회
	@GetMapping("/getUser")
	public UserVO getUser(UserVO vo) { 
		return userService.getUser(vo);
		
	}
	
}
