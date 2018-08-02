package com.bitcamp.openproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.model.MemberInfoView;
import com.bitcamp.service.GetMemberListService;

@Controller
public class MemberController {
	@Autowired 
	GetMemberListService getMemberListService;
	
	@RequestMapping("/memberList/xls")
	public ModelAndView getXlsPage() throws Exception {
		List<MemberInfoView> memberList = getMemberListService.getList();
		
		return new ModelAndView("MeberListXls", "memberList", memberList);
	}
	
	@RequestMapping("/memberList/pdf")
	public ModelAndView getPdfPage() throws Exception {
		List<MemberInfoView> memberList = getMemberListService.getList();
		
		return new ModelAndView("MeberListPdf", "memberList", memberList);
	}
	
	@RequestMapping("/memberList/list.xml")
	@ResponseBody
	public MemberList listXml() throws Exception {
		List<MemberInfoView> memberList = getMemberListService.getList();
		
		return new MemberList(memberList);
	}
	
	@RequestMapping("/memberList/list.json")
	@ResponseBody
	public MemberList listJson() throws Exception {
		List<MemberInfoView> memberList = getMemberListService.getList();
		
		return new MemberList(memberList);
	}
}