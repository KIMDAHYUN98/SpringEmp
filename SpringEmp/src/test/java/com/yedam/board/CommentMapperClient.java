package com.yedam.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.board.service.CommentVO;
import com.yedam.board.service.impl.CommentsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class CommentMapperClient {

	 @Autowired CommentsMapper commentsMapper;
	 
	 //@Test
	 public void insert() {
		 CommentVO vo = new CommentVO();
		 vo.setBoard_id("2");
		 vo.setContent("마이바티스 연동2");
		 vo.setName("user2");
		 commentsMapper.insertComments(vo);
	 }
	 
	 @Test
	 public void delete() {
		 CommentVO vo = new CommentVO();
		 vo.setIds(new String[]{"1", "2"});
		 commentsMapper.deleteComments(vo);
	 }
}
