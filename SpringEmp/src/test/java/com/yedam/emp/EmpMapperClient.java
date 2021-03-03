package com.yedam.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	@Autowired EmpMapper empMapper;
	
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
				.first_name("na")
				.last_name("test1")
				.email("a@a.a")
				.phone_number("010.222.2222")
				.hire_date(new java.sql.Date(new Date(0).getTime()))
				//.hire_date(new java.sql.Date(new Date().getTime()))
				.job_id("IT_PROG")
				.department_id("20")
				//.manager_id("101")
				.employee_id("4000")
				.build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1); // 등록된 건수가 넘어가면 1, 에러가 나면 0 출력
	}
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
				.first_name("na")
				.last_name("test1")
				.email("b@b.a")
				.hire_date(new java.sql.Date(new Date(0).getTime()))
				.hire_date(new java.sql.Date(new Date().getTime()))
				.job_id("IT_PROG")
				.department_id("20")
				.phone_number("010.222.2222")
				//.manager_id("101")
				.employee_id("5000")
				.build();
		int result = empMapper.insertEmp(vo);
		assertEquals(result, 1); // 등록된 건수가 넘어가면 1, 에러가 나면 0 출력
	}
	
	//@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build(); // build를 사용하면 더 편리함(lombok)
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		System.out.println(list);
	}
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		//assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO); // t/f vo가 null or Not null 인지 확인
		System.out.println();
	}
}
