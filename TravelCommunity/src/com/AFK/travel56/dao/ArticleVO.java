package com.AFK.travel56.dao;

import java.util.Date;

public class ArticleVO {

	private int articleNumber;
	private String articleTitle;
	private String articleContinent;
	private String articleCountry;
	private Date articleDate;
	private int articleRecommendCount;
	private int articleViewCount;
	private String articleContent;
	private int memberNumber;
	private String memberNickName;

	public ArticleVO(int articleNumber, String articleTitle,
			String articleContinent, String articleCountry, Date articleDate,
			int articleRecommendCount, int articleViewCount,
			String articleContent, int memberNumber,String memberNickName) {
		this.articleNumber = articleNumber;
		this.articleTitle = articleTitle;
		this.articleContinent = articleContinent;
		this.articleCountry = articleCountry;
		this.articleDate = articleDate;
		this.articleRecommendCount = articleRecommendCount;
		this.articleViewCount = articleViewCount;
		this.articleContent = articleContent;
		this.memberNumber = memberNumber;
		this.memberNickName=memberNickName;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContinent() {
		return articleContinent;
	}

	public void setArticleContinent(String articleContinent) {
		this.articleContinent = articleContinent;
	}

	public String getArticleCountry() {
		return articleCountry;
	}

	public void setArticleCountry(String articleCountry) {
		this.articleCountry = articleCountry;
	}

	public Date getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	public int getArticleRecommendCount() {
		return articleRecommendCount;
	}

	public void setArticleRecommendCount(int articleRecommendCount) {
		this.articleRecommendCount = articleRecommendCount;
	}

	public int getArticleViewCount() {
		return articleViewCount;
	}

	public void setArticleViewCount(int articleViewCount) {
		this.articleViewCount = articleViewCount;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	
}
