package com.face.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.face.model.Login;
import com.face.model.User;
import com.face.service.UserService;
@Controller
public class LoginController {
@Autowired
public UserService userService;

@RequestMapping(value="/hello", method = RequestMethod.GET)
	public  ModelAndView showlogin() {
	
	ModelAndView mav=new ModelAndView("login");
	return mav;
	
	}

@RequestMapping(value="/loginprocess", method = RequestMethod.POST)
public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse response,Login loginn) {
	ModelAndView mav=null;
	System.out.println("werty");
	User user=userService.validateUser(loginn);
	
	if(null !=user) {
		mav=new ModelAndView("welcome");
		mav.addObject("firstname", user.getFirstname());
	}
	else {
		mav=new ModelAndView("login");
		mav.addObject("message", "Username or Password is wrong!!");
	}
	return mav;
	}
}


