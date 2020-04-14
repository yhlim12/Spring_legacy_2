package com.iu.spring_2.member;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public int memberUpdate(MemberVO memberDTO) throws Exception{
		int result = memberDAO.memberUpdate(memberDTO);
		return result;
	}
	
	public int memberDelte(MemberVO memberDTO) throws Exception{
		int result = memberDAO.memberDelete(memberDTO);
		return result;
	}
	
	public MemberVO memberLogin(MemberVO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	
	public int memberJoin(MemberVO memberDTO) throws Exception{
		int result =memberDAO.memberJoin(memberDTO);
		return result;
		
	}
}
