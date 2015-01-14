package com.AFK.travel56.dao;

import java.util.Date;

public class ArticleRecommandVO {
	private Date recommandDate;
	private String memberNickname;
	private int articleNumber;
	private int memberNumber;
	
	public ArticleRecommandVO(Date recommandDate,String memberNickname, int articleNumber,int memberNumber ){
		this.recommandDate=recommandDate;
		this.memberNickname=memberNickname;
		this.articleNumber=articleNumber;
		this.memberNumber=memberNumber;
	}

	public Date getRecommandDate() {
		return recommandDate;
	}

	public void setRecommandDate(Date recommandDate) {
		this.recommandDate = recommandDate;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
}
