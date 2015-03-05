package com.davka.mylife.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.davka.mylife.entity.UserInfo;
import com.davka.mylife.service.impl.UserValidationImpl;

@Controller
public class UserManagerControler {
	 @Autowired
	 private UserValidationImpl userValidation; // 用户自定义验证
	 
	 @RequestMapping(value="/register")
	 public String toAddUserPage(Map<String, UserInfo> model) {
		 UserInfo userinfo = new UserInfo();
		 model.put("userInfo", userinfo);
		 return "user/register"; // 跳转到添加用户界面
	 }
	 
	 @RequestMapping(value="/adduser", method = RequestMethod.POST)
	 public ModelAndView processRegistration(@Valid UserInfo userinfo,BindingResult result) {
		 // set custom Validation by user
		 userValidation.validate(userinfo, result);
		 if (result.hasErrors()) {
			 List<ObjectError> ls=result.getAllErrors();
	            for (int i = 0; i < ls.size(); i++) {
	                System.out.println("error:"+ls.get(i));
	         }
			 Map<String,Object>  map = new HashMap<String, Object>();
			 map.put("hello",result.getErrorCount());
			 map.putAll(result.getModel());
			 return new ModelAndView("user/register",map);
		 }else{
			 Map<String,Object>  map = new HashMap<String, Object>();
			 map.put("hello","helloxxx");
		 return new ModelAndView("user/loginsuccess",map);
		 }
	 }
}
