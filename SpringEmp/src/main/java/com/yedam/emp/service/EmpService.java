package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;

public interface EmpService {
	// CRUD
	
	// 등록
		public int insertEmp(EmpVO vo);
	// 수정
		public int updateEmp(EmpVO vo);
	// 삭제
		public int DeleteEmp(EmpVO vo);
	// 단건조회
		public EmpVO getEmp(EmpVO vo);
	// 전체/검색 조회
		public List<EmpSearchVO> getSearchEmp(EmpSearchVO vo);
		
		public int getCount(EmpSearchVO vo);
	
}
