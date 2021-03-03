package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired JobMapper dao;
	
	@Override
	public int insertJob(JobVO vo) {
		return dao.insertJob(vo);
	}

	@Override
	public int updateJob(JobVO vo) {
		return dao.updateJob(vo);
	}

	@Override
	public int deleteJob(JobVO vo) {
		return dao.deleteJob(vo);
	}

	@Override
	public JobVO getJob(JobVO vo) {
		return dao.getJob(vo);
	}

	@Override
	public List<JobVO> getSearchJob(JobVO vo) {
		return dao.getSearchJob(vo);
	}

}
