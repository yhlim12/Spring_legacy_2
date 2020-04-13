package com.iu.spring_2.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	@RequestMapping(value="/memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	@RequestMapping(value="/memberJoin", method = RequestMethod.POST)
	public void memberJoin2() {
		System.out.println("MemberJoin");
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
	public String memberLogin2() {
		System.out.println("MemberLogin");
		
		return "redirect:../";
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
