package com.yedam.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentVO {
	private String id; // int(9), long(13자리), BigDecimal : oracle 최대 38자리 
	private String name;
	private String content;
	private String board_id;
    private String out_msg;
    private String[] ids; // @JsonIgnore, List<String>
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date wdate;
}
