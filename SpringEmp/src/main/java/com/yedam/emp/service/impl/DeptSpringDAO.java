package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired JdbcTemplate jdbc;
	
	private final String INSERT_DEPT = "insert into departments "
									+ "(department_id, "
									+ " department_name, "
									+ " manager_id, "
									+ " location_id) "
									+ " values(?, ?, ?, ?)";
	
	private final String UPDATE_DEPT = "UPDATE departments SET "
								+ "    department_name = ?, "
								+ "    manager_id = ?, "
								+ "    location_id = ? "
								+ "	   WHERE department_id = ?";
	
	private final String DELETE_EMP = "DELETE FROM departments WHERE department_id = ?";
	
	private final String GET_DEPT = "SELECT * FROM departments WHERE department_id = ?";	
	
	private final String GET_SERACH_DEPT = "select department_id, "
											+ " department_name, "
											+ " manager_id, "
											+ " location_id "
											+ " from departments"
											+ " order by department_id";
	
	// 등록
	public int insertDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT, vo.getDepartment_id()
										, vo.getDepartment_name()
										, vo.getManager_id()
										, vo.getLocation_id());
		return result;
	}
	
	// 수정
	public int updateDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT
										, vo.getDepartment_name()
										, vo.getManager_id()
										, vo.getLocation_id()
										, vo.getDepartment_id());
		return result;
	}
	
	// 삭제
	public int deleteDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_EMP, vo.getDepartment_id());
		return result;
	}
	
	// 단건조회
	public DeptVO getDept(DeptVO deptVO) {
		return jdbc.queryForObject(GET_DEPT, new DeptRowMapper(), deptVO.getDepartment_id());
	}
	
	// 검색조회
	public List<DeptVO> getSearchDept(DeptVO deptVO) {
		return jdbc.query(GET_SERACH_DEPT, new DeptRowMapper());
	}
	
	//rowMapper
	class DeptRowMapper implements RowMapper<DeptVO> {

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getInt("department_id"));
			vo.setDepartment_name(rs.getString("department_name"));
			vo.setManager_id(rs.getString("manager_id"));
			vo.setLocation_id(rs.getInt("location_id"));
			return vo;
		}
		
	}
	
	
}	
