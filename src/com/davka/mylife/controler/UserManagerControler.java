package com.davka.mylife.controler;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.davka.mylife.entity.UserInfo;
import com.davka.mylife.service.impl.UserValidationImpl;

@Controller
public class UserManagerControler {
	 @Autowired
	 private UserValidationImpl userValidation; // �û��Զ�����֤
	 
	 @RequestMapping(value="/toAddUserPage")
	 public String toAddUserPage(Map<String, UserInfo> model) {
		 UserInfo user = new UserInfo();
		 model.put("user", user);
		 return "user/register"; // ��ת������û�����
	 }
	 
	 @RequestMapping(value="/adduser", method = RequestMethod.POST)
	 public String processRegistration(@Valid UserInfo user,BindingResult result) {
		 // set custom Validation by user
		 userValidation.validate(user, result);
		 if (result.hasErrors()) {
			 return "user/register"; //��֤��ͨ������ת������û�����
		 }
		 return "user/loginsuccess"; //��֤ͨ������ת����ӳɹ�����
	 }
}
