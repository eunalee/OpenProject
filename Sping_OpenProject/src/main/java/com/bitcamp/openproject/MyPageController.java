package com.bitcamp.openproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.model.BoardInfo;
import com.bitcamp.model.MemberInfo;
import com.bitcamp.service.BoardListView;
import com.bitcamp.service.DeleteService;
import com.bitcamp.service.EditService;
import com.bitcamp.service.GetBoardListService;
import com.bitcamp.service.MyPageService;

@Controller
public class MyPageController {
	@Autowired
	MyPageService myPageService;
	
	@Autowired
	GetBoardListService getBoardListService;
	
	@RequestMapping("/mypage")
	public String getMypage(HttpServletRequest request, HttpSession session, MemberInfo memberInfo, Model model) throws Exception {
		MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
		
/*		String pageNumStr = request.getParameter("page");
		
		int pageNum = 1;
		
		if(pageNumStr != null)
			pageNum = Integer.parseInt(pageNumStr);
		
		BoardListView viewData = getBoardListService.getList(member.getId(), pageNum);*/
		
		model.addAttribute("member", myPageService.getInfo(member.getId()));
/*		model.addAttribute("pageNum", pageNum);
		model.addAttribute("viewData", viewData);
		model.addAttribute("boardList", viewData.getBoardList());
		model.addAttribute("totalPageCount", viewData.getPageTotalCount());*/
		
		return "mypage";
	}
}