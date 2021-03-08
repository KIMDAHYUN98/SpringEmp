package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmpValidation  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	// 에러 발생시 Error 객체에 담는다.
	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO)target; // 다운 캐스팅, 검사할 vo (=target)
		// vo에 있는 필드 값을 검사한다.
		// error를 담는 객체 생성 방법이 두가지
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null, 
				"Empty last_name is now allowed.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null, 
				"Empty hire_date is now allowed.");
		if(emp.getEmail() == null || emp.getEmail().isEmpty())
			 errors.rejectValue("email", null, "email not null");
		if(emp.getDepartment_id() == null || emp.getDepartment_id().isEmpty())
			errors.rejectValue("department_id", null, "department_id not null");

	}
	

}
