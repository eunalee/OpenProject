package com.bitcamp.openproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.model.MemberInfo;
import com.bitcamp.service.InvalidLoginException;
import com.bitcamp.service.LoginService;
import com.bitcamp.service.MemberInfoNotFoundException;
import com.bitcamp.service.ServiceException;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm(@CookieValue(value="id", defaultValue="0") String cookie, Model model) {
		model.addAttribute("id", cookie);
		
		return "loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String password, Model model) throws Exception {
		MemberInfo memberInfo = loginService.login(id, password);
		
		session.setAttribute("memberInfo", memberInfo);
		
		return "index";
	}
	
	@ExceptionHandler(Exception.class)
	public String Exception(Exception e) {
		return "exception";
	}
	
/*	@ExceptionHandler(ServiceException.class)
	public String ServiceException(ServiceException e) {
		return "exception";
	}
	
	@ExceptionHandler(MemberInfoNotFoundException.class)
	public String MemberInfoNotFoundException(MemberInfoNotFoundException e) {
		return "exception";
	}
	
	@ExceptionHandler(InvalidLoginException.class)
	public String InvalidLoginException(InvalidLoginException e) {
		return "exception";
	}*/
}