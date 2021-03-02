package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_EMP = "INSERT INTO EMPLOYEES "
									+ " (EMPLOYEE_ID, "
									+ " LAST_NAME,"
									+ " EMAIL,"
									+ " HIRE_DATE,"
									+ " JOB_ID,"
									+ " FIRST_NAME, "
									+ " DEPARTMENT_ID,"
									+ " PHONE_NUMBER"
									+ " MANAGER_ID) "
									+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String UPDATE_EMP = "UPDATE EMPLOYEES SET "
								+ "    FIRST_NAME = ?, "
								+ "    LAST_NAME = ?, "
								+ "    EMAIL = ?, "
								+ "    PHONE_NUMBER = ?, "
								+ "    HIRE_DATE = ?, "
								+ "    JOB_ID = ?, "
								+ "    MANAGER_ID = ?,  "
								+ "    DEPARTMENT_ID = ? "
								+ "	   WHERE EMPLOYEE_ID = ?";
	
	private final String DELETE_EMP="";
	
	private final String GET_EMP = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
	
	private final String GET_SERACH_EMP = "select EMPLOYEE_ID, "
										+ " FIRST_NAME, "
										+ " LAST_NAME, "
										+ " EMAIL, "
										+ " PHONE_NUMBER, "
										+ " HIRE_DATE, "
										+ " JOB_ID, "
										+ " SALARY, "
										+ " COMMISSION_PCT, "
										+ " MANAGER_ID, "
										+ " DEPARTMENT_ID "
									+ " from employees"
									+ " order by FIRST_NAME";

	// 등록
	
	public int insertEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_EMP, vo.getEmployee_id()
										 , vo.getLast_name()
										 , vo.getEmail()
										 , vo.getHire_date()
										 , vo.getJob_id()
										 , vo.getFirst_name()
										 , vo.getDepartment_id()
										 , vo.getPhone_number()
										 , vo.getManager_id() );
		return result;
	}
	
	// 수정
	
	public int updateEmp(EmpVO vo) {
		int result = 0;
		
		return result;
	}
	
	// 삭제
	
	// 단건 조회
	
	public EmpVO getEmp(EmpVO empVO) {
		return jdbc.queryForObject(GET_EMP, new EmpRowMapper(), 
											empVO.getEmployee_id());
	}
	
	// 검색 조회
	
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
		return jdbc.query(GET_SERACH_EMP, new EmpRowMapper());
	}
	
	//rowmapper
	class EmpRowMapper implements RowMapper<EmpVO> {

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo.setEmployee_id(rs.getString(1));
			vo.setFirst_name(rs.getString("FIRST_NAME"));
			vo.setLast_name(rs.getString(3));
			vo.setEmail(rs.getString(4));
			vo.setPhone_number(rs.getString(5));
			vo.setHire_date(rs.getDate(6));
			vo.setJob_id(rs.getString(7));
			vo.setSalary(rs.getString(8));
			vo.setCommission_pct(rs.getString(9));
			vo.setManager_id(rs.getString("MANAGER_ID"));
			vo.setDepartment_id(rs.getString("DEPARTMENT_ID"));
			return vo;
		}
		
	}
}
