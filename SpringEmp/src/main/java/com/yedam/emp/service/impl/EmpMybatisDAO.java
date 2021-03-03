package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;
@Repository
public class EmpMybatisDAO {
	
	@Autowired SqlSessionTemplate sqlSession; // 스프링에서 상속받아 사용하기 좋음
	
	public int insertEmp(EmpVO vo) {
		return sqlSession.insert("EmpDAO.insertEmp", vo);
	}
	public int updateEmp(EmpVO vo) {
		return sqlSession.update("EmpDAO.updateEmp", vo);
	}
	public int deleteEmp(EmpVO vo) {
		return sqlSession.delete("EmpDAO.deleteEmp", vo);
	}
	public EmpVO getEmp(EmpVO empVO) {
		return sqlSession.selectOne("EmpDAO.getEmp", empVO);
	}
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
		System.out.println("mybatis list");
		return sqlSession.selectList("EmpDAO.getSearchEmp", empVO);
	}
	
	// 조회 기능
}
