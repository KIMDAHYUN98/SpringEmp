package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.JobVO;

public interface JobMapper {
	
	public int insertJob(JobVO vo);
	
	public int updateJob(JobVO vo);
	
	public int deleteJob(JobVO vo);
	
	public JobVO getJob(JobVO vo);
	
	public List<JobVO> getSearchJob(JobVO vo);
}
