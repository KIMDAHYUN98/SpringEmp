package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserMapper dao;
	
	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	}

	@Override
	public int deletetUser(UserVO vo) {
		return dao.deletetUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}

	@Override
	public boolean loginCheck(UserVO vo) {
		// 단건 조회
		 UserVO userVO = dao.getUser(vo);
		
		 // 아이디가 일치하는 지 체크
		 if(userVO == null) {
			 return false;
		 }
		
		// 아이디가 같으면 패스워드 일치하는 지 체크
		if(userVO.getPassword().equals(vo.getPassword())) { 	// db의 password VS vo.getPassword 비교
		
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updatePw(UserVO vo) { // 패스워드 변경
		// 단건 조회
		UserVO userVO = dao.getUser(vo);
		
		// 기존 패스워드와 일치하는 지 체크		
		if(userVO.getPassword().equals(vo.getOldpassword())) {
			dao.updatePw(vo);
		 	return true;
		} else {
			return false;
		}
	
	}
}
