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
	 private UserValidationImpl userValidation; // 用户自定义验证
	 
	 @RequestMapping(value="/toAddUserPage")
	 public String toAddUserPage(Map<String, UserInfo> model) {
		 UserInfo user = new UserInfo();
		 model.put("user", user);
		 return "user/register"; // 跳转到添加用户界面
	 }
	 
	 @RequestMapping(value="/adduser", method = RequestMethod.POST)
	 public String processRegistration(@Valid UserInfo user,BindingResult result) {
		 // set custom Validation by user
		 userValidation.validate(user, result);
		 if (result.hasErrors()) {
			 return "user/register"; //验证不通过，跳转回添加用户界面
		 }
		 return "user/loginsuccess"; //验证通过，跳转到添加成功界面
	 }
}
