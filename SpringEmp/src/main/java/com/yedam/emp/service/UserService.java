package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserService {
	
	public void insertUser(UserVO vo);
	
	public void updateUser(UserVO vo);
	
	public int deletetUser(UserVO vo);
	
	public UserVO getUser(UserVO vo);
	
	public List<UserVO> getSearchUser(UserVO vo);
	
	// 로그인(boolean OR int)
	public boolean loginCheck(UserVO vo);
	
	// 패스워드 변경
	public boolean updatePw(UserVO vo);
}	
