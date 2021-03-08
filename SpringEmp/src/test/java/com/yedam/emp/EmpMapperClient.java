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
import org.springframework.transaction.annotation.Transactional;

import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	//@Autowired EmpMapper empMapper;
	
	@Autowired EmpService empSerivce;
	
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
				.first_name("t2")
				.last_name("t2")
				.email("d@d.d")
				.phone_number("010.232.2222")
				.hire_date(new java.sql.Date(new Date(0).getTime()))
				//.hire_date(new java.sql.Date(new Date().getTime()))
				.job_id("IT_PROG")
				.department_id("20")
				//.manager_id("101")
				.employee_id("1005")
				.build();
		int result = empSerivce.updateEmp(vo);
		assertEquals(result, 1); // 등록된 건수가 넘어가면 1, 에러가 나면 0 출력
	}
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
				.first_name("t4")
				.last_name("t4")
				.email("eezz@e.e")
				.hire_date(new java.sql.Date(new Date().getTime()))
				.job_id("IT_PROG")
				.department_id("20")
				.phone_number("010.222.2222")
				.manager_id("101")
				.employee_id("1010")
				.build();
		int result = empSerivce.insertEmp(vo);
		assertEquals(result, 1); // 등록된 건수가 넘어가면 1, 에러가 나면 0 출력
	
	}
	
	//@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build(); // build를 사용하면 더 편리함(lombok)
		List<EmpSearchVO> list = empSerivce.getSearchEmp(vo);
		System.out.println(list);
	}
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empSerivce.getEmp(vo);
		//assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO); // t/f vo가 null or Not null 인지 확인
		System.out.println();
	}
}
