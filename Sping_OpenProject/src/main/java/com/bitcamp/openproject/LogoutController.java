package com.bitcamp.openproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession(false).invalidate();
		
		return "redirect:/";
	}
}