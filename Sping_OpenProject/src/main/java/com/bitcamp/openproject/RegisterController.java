package com.bitcamp.openproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.model.MemberInfo;
import com.bitcamp.service.RegisterService;
import com.bitcamp.service.ServiceException;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String registerForm() {
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(HttpServletRequest request, MemberInfo memberInfo, Model model) throws Exception {
		int insertCnt = registerService.register(memberInfo, request);
		model.addAttribute("insertCnt", insertCnt);
		
		return "register";
	}
}