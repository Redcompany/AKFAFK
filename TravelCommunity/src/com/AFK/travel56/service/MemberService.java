package com.AFK.travel56.service;

import com.AFK.travel56.dao.MemberDAO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.dao.MySqlMemberDAO;

public class MemberService {

	MemberDAO memberDAO = new MySqlMemberDAO();

	// ID / 닉네임 중복검사
	public boolean checkOverlapByID(String memberID) {

		MemberVO memberVO = memberDAO.findMemberByID(memberID);

		if (memberID.equals(memberVO.getMemberID())) {
			return false;
		}
		return true;
	}

	public boolean checkOverlapByNickName(String memberNickName) {

		MemberVO memberVO = memberDAO.findMemberByID(memberNickName);

		if (memberNickName.equals(memberVO.getMemberNickName())) {
			return false;
		}
		return true;
	}

	// 회원 가입
	public boolean registerMember(String memberID, String memberPW,
			String memberGender, String memberEmail, String address,
			String memberName, String memberBirth, String memberNickName) {
		boolean genderCheck;
		String totalEmail;
		if (memberGender.equals("man")) {
			genderCheck = true;
		} else {
			genderCheck = false;
		}
		totalEmail = memberEmail + "@" + address;
		int stateCheck = memberDAO.addMember(memberID, memberPW, genderCheck,
				totalEmail, memberName, memberBirth, memberNickName);

		if (stateCheck != 0) {
			return true;
		}
		return false;
	}

	// 회원 수정
	public boolean updateMember(String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberBirth, String memberPhone, String memberNickName) {

		MemberVO memberVO = memberDAO.findMemberByNickName(memberNickName);

		if (memberPW.equals(null)) {
			memberPW = memberVO.getMemberPW();
		}

		if (memberEmail.equals(null)) {
			memberEmail = memberVO.getMemberEmail();
		}

		if (memberName.equals(null)) {
			memberName = memberVO.getMemberName();
		}

		if (memberPhone.equals(null)) {
			memberPhone = memberVO.getMemberPhone();
		}

		int stateCheck = memberDAO.updateMember(memberID, memberPW,
				memberGender, memberEmail, memberName, memberBirth,
				memberPhone, memberNickName);

		if (stateCheck != 0) {
			return true;
		}

		return false;
	}

	// 회원 로그인
	public boolean loginMember(String memberID, String memberPW) {

		MemberVO memberVO = memberDAO.memberLogin(memberID, memberPW);

		if (memberVO != null) {
			return true;
		}

		return false;
	}

	// 회원 삭제
	public boolean deleteMember(String memberID, String memberPW) {

		int stateCheck = memberDAO.deleteMember(memberID, memberPW);

		if (stateCheck != 0) {
			return true;
		}

		return false;
	}

	public boolean findMemberID(String memberName, String memberBirth,
			String memberNickname) {
		MemberVO findMember = memberDAO.findMemberByNameBirthNickname(
				memberName, memberBirth, memberNickname);
		if (findMember != null) {
			return true;
		}
		return false;
	}

	public boolean findMemberPassword(String memberID, String memberName,
			String memberBirth) {
		MemberVO findMember = memberDAO.findMemberByIDNameBirth(memberID,
				memberName, memberBirth);
		if (findMember != null) {
			return true;
		}
		return false;
	}
	//로그인체크
		public MemberVO loginCheck(String memberID) {
			MemberVO loginCheak = memberDAO.loginCheck(memberID);
			return MySqlMemberDAO.loginCheck(memberID);
		}
}
