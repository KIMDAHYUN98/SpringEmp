package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserService {
public void insertUser(UserVO vo);
	
	public void updateUser(UserVO vo);
	
	public int deletetUser(UserVO vo);
	
	public UserVO getUser(UserVO vo);
	
	public List<UserVO> getSearchUser(UserVO vo);
}	
