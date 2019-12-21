package com.face.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.face.model.User;
import com.face.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView mav=new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value = "/registration",method=RequestMethod.GET)
	public ModelAndView  showRegister() {		
		ModelAndView mav=new ModelAndView("registration");
		return mav;
	}
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response,User user) {
		userService.register(user);
		
		return new ModelAndView("welcome","firstname",user.getFirstname());
		
	}
}
