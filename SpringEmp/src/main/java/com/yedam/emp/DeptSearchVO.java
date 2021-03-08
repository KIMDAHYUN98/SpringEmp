package com.yedam.emp;

import lombok.Data;

@Data
public class DeptSearchVO extends DeptVO {
	// int : 아무것도 안넘기면 400 에러 / integer : null 값도 들어갈 수 있다. 결과가 다름
	Integer page = 1;
	int start = 1;
	int end = 10;
}
