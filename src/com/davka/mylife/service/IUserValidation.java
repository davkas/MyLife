package com.davka.mylife.service;

import org.springframework.validation.Errors;

public interface IUserValidation {
	public boolean supports(Class<?> klass);
	public void validate(Object target, Errors errors) ;
}
