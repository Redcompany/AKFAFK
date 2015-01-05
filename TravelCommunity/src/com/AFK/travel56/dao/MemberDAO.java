package com.AFK.travel56.dao;

import java.util.List;

public interface MemberDAO {

	public List<MemberVO> findAllMembers();

	public MemberVO findMemberByNickName(String memberNickName);

	public MemberVO findMemberByID(String memberID);

	public int updateMember(String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberBirth, String memberPhone, String memberNickName);

	public int deleteMember(String memberID, String memberPW);

	public int addMember(String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberBirth, String memberNickName);

	public MemberVO memberLogin(String memberID, String memberPW);

	public MemberVO findMemberByIDNameBirth(String memberID, String memberName,
			String memberBirth);

	public MemberVO findMemberByNameBirthNickname(String memberName,
			String memberBirth, String memberNickname);
}
