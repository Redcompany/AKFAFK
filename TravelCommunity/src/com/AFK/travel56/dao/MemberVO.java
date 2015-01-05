package com.AFK.travel56.dao;

public class MemberVO {

	private int memberNumber;
	private String memberID;
	private String memberPW;
	private boolean memberGender;
	private String memberEmail;
	private String memberName;
	private String memberPhone;
	private String memberBirth;
	private String memberNickName;

	public MemberVO(int memberNumber, String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberPhone, String memberBirth, String memberNickName) {
		this.memberNumber = memberNumber;
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberGender = memberGender;
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberNickName = memberNickName;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public boolean isMemberGender() {
		return memberGender;
	}

	public void setMemberGender(boolean memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String toString() {
		return memberNumber + " " + memberID + " " + memberPW + " "
				+ memberGender + " " + memberEmail + " " + memberPhone;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

}
