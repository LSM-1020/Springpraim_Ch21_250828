package com.LSM.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.LSM.member.Dao.MemberDao;
import com.LSM.member.Dto.MemberDto;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value="/join")
	public String join() {
		return "join";
	}
	@RequestMapping(value="/search")
	public String search() {
		return "searchmember";
	}
	@RequestMapping(value="/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		MemberDto mDto = memberDao.searchMember(request.getParameter("memberid"));
		model.addAttribute("mDto",mDto);
		model.addAttribute("result","1");
		
		return "searchmember";
	}
	@RequestMapping(value="/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		int mage = Integer.parseInt(request.getParameter("memberage")) ;
		
		//MemberDao memberDao = new MemberDao();
		//memberDao.insertMember(mid, mpw, mname, mage);
		memberDao.insertMember(mid, mpw, mname, mage);
		
		
		return "redirect:memberlist";
	}
	@RequestMapping(value="/memberlist")
	public String memberlist(Model model) {
		List<MemberDto> mDtos= memberDao.searchMembers();
		model.addAttribute("mDtos",mDtos);
		return "memberlist";
	}
	
	
}
