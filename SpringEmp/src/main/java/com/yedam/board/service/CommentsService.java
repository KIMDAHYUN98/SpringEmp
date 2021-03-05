package com.yedam.board.service;

import java.util.List;

public interface CommentsService {
	public void insertComments(CommentVO vo);
	
	public void updateComments(CommentVO vo);
	
	public int deleteComments(CommentVO vo);
	
	public CommentVO getComments(CommentVO vo);
	
	public List<CommentVO> getSearchComments(CommentVO vo);
}
