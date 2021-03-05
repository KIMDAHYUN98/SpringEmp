package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentVO;
import com.yedam.board.service.CommentsService;

@RestController
public class CommentsController {
	@Autowired CommentsService commentsService;

	// 등록
	
	@PostMapping("/comments")
	public CommentVO insertCommentsProc(@RequestBody CommentVO vo) {
		commentsService.insertComments(vo);
		if(vo.getId().equals("0")) { // 아이디 값이 등록되지 않았을 때
			return vo; // 에러 발생
		} else {		
		return commentsService.getComments(vo);
		}
	}
	
	// 수정
	@PutMapping("/comments") // 처리하고자 하는 자원 이름(제이슨 구조)
	public CommentVO updateCommentsProc(@RequestBody CommentVO vo) { // parse 해서 자바 객체인 vo에 담아준다.
		System.out.println("수정=======" + vo);
		return vo;
		
		// 입력값을 바꾸는 게 RequestBody, 리턴 값을 바꾸는 게 ResponseBody
	}
	
	// 삭제
	@DeleteMapping(value = "/comments") //method = RequestMethod.DELETE
	public Map deleteCommentsProc(@RequestBody CommentVO vo ) {
		System.out.println(vo);
		int r = commentsService.deleteComments(vo); // map : json
		return  Collections.singletonMap("cnt", r); // map 객체에 속성을 추가한다.
	}
	
	// =====================JSON타입으로 변환 : @RequestBody
	
	// 해당 게시글의 댓글 조회
	@GetMapping("/comments")
	public List<CommentVO> getSearchCommentsProc(CommentVO vo) {
		return commentsService.getSearchComments(vo);
	}
	
	// 단건 조회
	@GetMapping("/comments/{id}")
	public CommentVO getCommentsProc(CommentVO vo,
									 @PathVariable String id) {	
		vo.setId(id);
		return commentsService.getComments(vo);
	}
	
}
