package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentVO;
import com.yedam.board.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired CommentsMapper dao;
	
	@Override
	public void insertComments(CommentVO vo) {
		dao.insertComments(vo);
	}

	@Override
	public void updateComments(CommentVO vo) {
		dao.updateComments(vo);
		
	}

	@Override
	public int deleteComments(CommentVO vo) {
		
		return dao.deleteComments(vo);
		
	}

	@Override
	public CommentVO getComments(CommentVO vo) {
		return dao.getComments(vo);
	}

	@Override
	public List<CommentVO> getSearchComments(CommentVO vo) {
		return dao.getSearchComments(vo);
	}

}
