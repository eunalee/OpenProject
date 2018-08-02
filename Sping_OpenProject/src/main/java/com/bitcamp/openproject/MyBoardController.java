package com.bitcamp.openproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.model.BoardInfo;
import com.bitcamp.model.MemberInfo;
import com.bitcamp.service.BoardListView;
import com.bitcamp.service.DeleteService;
import com.bitcamp.service.EditService;
import com.bitcamp.service.GetBoardListService;
import com.bitcamp.service.MyPageService;
import com.bitcamp.service.WriteService;

@Controller
public class MyBoardController {
	@Autowired
	MyPageService myPageService;
	
	@Autowired
	GetBoardListService getBoardListService;
	
	@Autowired
	WriteService writeService;
	
	@Autowired
	EditService editService;
	
	@Autowired
	DeleteService deleteService;
	
	@RequestMapping("/writeForm")
	public String writeForm(HttpSession session, Model model)  {
		
		model.addAttribute("member", (MemberInfo)session.getAttribute("memberInfo"));
		
		return "writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(HttpServletRequest request, HttpSession session, BoardInfo boardInfo, Model model) throws Exception {
		boardInfo.setWriter_id(request.getParameter("writer_id"));
		
		int resultCnt = writeService.write(boardInfo);
		
		if(resultCnt > 0) {
			MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
			
			String pageNumStr = request.getParameter("page");
			
			int pageNum = 1;
			
			if(pageNumStr != null)
				pageNum = Integer.parseInt(pageNumStr);
			
			BoardListView viewData = getBoardListService.getList(member.getId(), pageNum);
			
			model.addAttribute("member", myPageService.getInfo(member.getId()));
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("viewData", viewData);
			model.addAttribute("boardList", viewData.getBoardList());
			model.addAttribute("totalPageCount", viewData.getPageTotalCount());
			
			return "myboard";
		}
		
		else
			throw new Exception();
	}
	
	@RequestMapping("/myboard")
	public String getMypage(HttpServletRequest request, HttpSession session, MemberInfo memberInfo, Model model) throws Exception {
		MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
		
		String pageNumStr = request.getParameter("page");
		
		int pageNum = 1;
		
		if(pageNumStr != null)
			pageNum = Integer.parseInt(pageNumStr);
		
		BoardListView viewData = getBoardListService.getList(member.getId(), pageNum);
		
		model.addAttribute("member", myPageService.getInfo(member.getId()));
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("viewData", viewData);
		model.addAttribute("boardList", viewData.getBoardList());
		model.addAttribute("totalPageCount", viewData.getPageTotalCount());
		
		return "myboard";
	}
	
	@RequestMapping("/myboard/{page}")
	public String getMypage(@PathVariable int page, HttpServletRequest request, HttpSession session, MemberInfo memberInfo, Model model) throws Exception {
		MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
		
		//String pageNumStr = request.getParameter("page");
		
		//int pageNum = 1;
		
		if(page == 0)
			page = 1;
		
		BoardListView viewData = getBoardListService.getList(member.getId(), page);
		
		model.addAttribute("member", myPageService.getInfo(member.getId()));
		model.addAttribute("pageNum", page);
		model.addAttribute("viewData", viewData);
		model.addAttribute("boardList", viewData.getBoardList());
		model.addAttribute("totalPageCount", viewData.getPageTotalCount());
		
		return "myboard";
	}
	
	@RequestMapping("/editForm/{board_id}")
	public String editForm(@PathVariable("board_id") int board_id, HttpServletRequest request, Model model) throws Exception {
		MemberInfo member = (MemberInfo)request.getSession(false).getAttribute("memberInfo");
		
		BoardInfo boardInfo = getBoardListService.getListById(board_id);
		
		model.addAttribute("boardInfo", boardInfo);
		model.addAttribute("memberId", member.getId());
		
		return "editForm";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(HttpServletRequest request, HttpSession session, BoardInfo boardInfo, Model model) throws Exception {
		//int resultCnt = editService.edit(Integer.parseInt(request.getParameter("board_id")), request.getParameter("title"), request.getParameter("content"));
		
		int resultCnt = editService.edit(boardInfo);
		
		if(resultCnt > 0) {
			MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
			
			String pageNumStr = request.getParameter("page");
			
			int pageNum = 1;
			
			if(pageNumStr != null)
				pageNum = Integer.parseInt(pageNumStr);
			
			BoardListView viewData = getBoardListService.getList(member.getId(), pageNum);
			
			model.addAttribute("member", myPageService.getInfo(member.getId()));
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("viewData", viewData);
			model.addAttribute("boardList", viewData.getBoardList());
			model.addAttribute("totalPageCount", viewData.getPageTotalCount());
			
			return "myboard";
		}
		
		else
			throw new Exception();
	}
	
	@RequestMapping("/delete/{board_id}")
	public String deleteContent(@PathVariable("board_id") int board_id, HttpServletRequest request, HttpSession session, Model model) throws Exception {
		int resultCnt = deleteService.delete(board_id);
		
		if(resultCnt > 0) {
			MemberInfo member = (MemberInfo)session.getAttribute("memberInfo");
			
			String pageNumStr = request.getParameter("page");
			
			int pageNum = 1;
			
			if(pageNumStr != null)
				pageNum = Integer.parseInt(pageNumStr);
			
			BoardListView viewData = getBoardListService.getList(member.getId(), pageNum);
			
			model.addAttribute("member", myPageService.getInfo(member.getId()));
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("viewData", viewData);
			model.addAttribute("boardList", viewData.getBoardList());
			model.addAttribute("totalPageCount", viewData.getPageTotalCount());
			
			return "myboard";
		}
		
		else
			throw new Exception();
	}
}