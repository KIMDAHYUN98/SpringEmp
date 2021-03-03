package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//DAO
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {
	// DAO를 부름
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	@Override
	public int insertEmp(EmpVO vo) {
		return dao.insertEmp(vo);
	}

	@Override
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

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return dao.getSearchEmp(vo);
	}
	
	
	
}
