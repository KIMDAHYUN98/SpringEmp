package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.emp.EmpSearchVO;
//DAO
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {
	// DAO를 부름
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	
	@Autowired EmpMapper dao;
	
	//@Transactional
	public int insertEmp(EmpVO vo) { 
			   //deptService.insert() // 다른 서비스 부를 떄 새로운 트랜잭션을 생성 할 것 인가? 아님 기존 트랜잭션을 사용할 것인가?
			  // dao.insertEmp(vo); // 트랜잭션 자동 커밋
		return dao.insertEmp(vo); // 에러(uk)발생, 트랜잭션 지정된 경우는 모든 쿼리가 롤백됨
	}

	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	@Override
	public int DeleteEmp(EmpVO vo) {
		return dao.DeleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}
	/*
	 * @Override public List<EmpSearchVO> getSearchEmp(EmpSearchVO vo) { return }
	 */
	
	public int getCount(EmpSearchVO vo) {
		return dao.getCount(vo);
	}

	@Override
	public List<EmpSearchVO> getSearchEmp(EmpVO vo) {
		return dao.getSearchEmp(vo);
	}
	
	
	
}
