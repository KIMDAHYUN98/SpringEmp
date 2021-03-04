package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO {
	
	// 페이징(페이지 관련된 vo 추가)
	Integer page = 1;
	int start = 1;
	int end = 10;

}
