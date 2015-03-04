package com.davka.mylife.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.davka.mylife.entity.UserInfo;
import com.davka.mylife.service.IUserValidation;

@Component("userValidator")
public class UserValidationImpl implements IUserValidation {

	@Override
	public boolean supports(Class<?> klass) {
		// TODO Auto-generated method stub
		return UserInfo.class.isAssignableFrom(klass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		 UserInfo registration = (UserInfo) target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
		 "NotEmpty.registration.userName",
		 "用户名不能为空.");
		 String userName = registration.getUserName();
		 if ((userName.length()) > 50) {
		 errors.rejectValue("userName",
		 "lengthOfUser.registration.userName",
		 "User Name must not more than 50 characters.");
		 }
		 if (!(registration.getPassword()).equals(registration.getConfirmPassword())) {
		 errors.rejectValue("password",
		 "matchingPassword.registration.password",
		 "Password and Confirm Password Not match.");
		 }
	}
	
}
