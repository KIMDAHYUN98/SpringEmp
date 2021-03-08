package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;

public interface EmpMapper { 
	// 해당 인터페이스는  DAO로 쓰일 것이다.
	
		// 등록
			public int insertEmp(EmpVO vo);
		// 수정
			public int updateEmp(EmpVO vo);
		// 삭제
			public int DeleteEmp(EmpVO vo);
		// 단건조회
			public EmpVO getEmp(EmpVO vo);
		// 전체/검색 조회
			public List<EmpSearchVO> getSearchEmp(EmpVO vo);
		// 건수
			public int getCount(EmpSearchVO vo);
}
