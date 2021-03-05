package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yedam.board.service.CommentVO;

public interface CommentsMapper {
// 추상 메소드 생성하기
	
	public void insertComments(CommentVO vo);
	
	public void updateComments(CommentVO vo);
	
	public int deleteComments(CommentVO vo);
	
	public CommentVO getComments(CommentVO vo);
	
	public List<CommentVO> getSearchComments(CommentVO vo);
}
