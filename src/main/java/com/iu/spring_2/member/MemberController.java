package com.iu.spring_2.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	
	@RequestMapping(value="/memberJoin")
	public String memberJoin(Model model) {
		String id ="test";
		model.addAttribute(id);
		return "member/memberJoin";
	}
	@RequestMapping(value="/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberVO memberVO) {
		//MemberVo의 맴버변수의 값으로 파라미터 값 넣기
		
		 System.out.println(memberVO.getId()); 
		 System.out.println(memberVO.getPassword());
		 System.out.println(memberVO.getName());
		 System.out.println(memberVO.getEmail());
		 System.out.println(memberVO.getPhone());
		 System.out.println(memberVO.getAge());
	
	}
	
	@RequestMapping(value="/memberMypage", method = RequestMethod.POST)
	public void memberMypage2() {
		System.out.println("Mypage");
	}
	
	@RequestMapping(value="/memberLogin")
	public String memberLogin() {
		return "member/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method = RequestMethod.POST)
	public String memberLogin2(HttpSession session, MemberVO memberDTO, Model model) throws Exception {
		
		memberDTO.setId(memberDTO.getId());
		memberDTO.setPassword(memberDTO.getPassword());
		
		
		memberDTO = memberService.memberLogin(memberDTO);
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			return "redirect:../";
		}else {
			model.addAttribute("result", "LoginFail");
			model.addAttribute("path", "./memberLogin");
			return "member/memberLogin";
		}
		
		 //로그인 성공이면 index 
		 //로그인 실패하면 로그인 실패 alert후 login form으로 이동
		 
	}
	
	@RequestMapping(value="/memberUpdate")
	public String memberUpdate() {
		return "member/memberUpdate";
	}
	
	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST )
	public void memberUpdate2() {
		System.out.println("MemberUpdate");
	}

}
