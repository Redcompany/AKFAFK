package com.AFK.travel56.dao;

import java.util.Date;

public class CommentVO {

	private int commentNumber;
	private Date commentdate;
	private String commentContent;
	private int memberNumber;
	private String memberNickName;
	private int articleNumber;
	private int parentComment;

	public CommentVO(int commentNumber, Date commentdate,
			String commentContent, int memberNumber, String memberNickName,
			int articleNumber, int parentComment) {
		this.commentNumber = commentNumber;
		this.commentdate = commentdate;
		this.commentContent = commentContent;
		this.memberNumber = memberNumber;
		this.memberNickName = memberNickName;
		this.articleNumber = articleNumber;
		this.parentComment = parentComment;
	}

	public int getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public int getParentComment() {
		return parentComment;
	}

	public void setParentComment(int parentComment) {
		this.parentComment = parentComment;
	}
}
