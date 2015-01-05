package com.AFK.travel56.service;

import java.util.List;

import com.AFK.travel56.dao.ArticleDAO;
import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.CommentDAO;
import com.AFK.travel56.dao.CommentVO;
import com.AFK.travel56.dao.MemberDAO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.dao.MySqlArticleDAO;
import com.AFK.travel56.dao.MySqlCommentDAO;
import com.AFK.travel56.dao.MySqlMemberDAO;

public class CommentService {
	CommentDAO commentDAO = new MySqlCommentDAO();
	ArticleDAO articleDAO = new MySqlArticleDAO();
	MemberDAO memberDAO = new MySqlMemberDAO();

	//댓글 등록
	public boolean registerComment(String commentContent, int memberNumber,
			String memberNickName, int articleNumber) {
		MemberVO findMember = memberDAO.findMemberByNickName(memberNickName);
		ArticleVO findArticle = articleDAO.showSelectArticle(articleNumber);
		if (findArticle != null) {
			int checkState = commentDAO.addComment(commentContent,
					findMember.getMemberNumber(),
					findMember.getMemberNickName(),
					findArticle.getArticleNumber());
			if (checkState != 0) {
				return true;
			}
		}
		return false;
	}

	//댓글의 댓글 등록
	
	public boolean registerCommentOfComment(String commentContent,
			int memberNumber, String memberNickName, int articleNumber,
			int parentComment) {
		MemberVO findMember = memberDAO.findMemberByNickName(memberNickName);
		ArticleVO findArticle = articleDAO.showSelectArticle(articleNumber);
		CommentVO findComment = commentDAO
				.findCommentByCommentNumber(parentComment);
		if (findMember != null && findComment != null) {
			int checkState = commentDAO.addCommentOfComment(commentContent,
					findMember.getMemberNumber(),
					findMember.getMemberNickName(),
					findArticle.getArticleNumber(),
					findComment.getArticleNumber());
			if (checkState != 0) {
				return true;
			}
		}

		return false;
	}

	//댓글삭제
	public boolean deleteComment(int commentNumber, int memberNumber,
			String memberNickName) {
		int checkState = commentDAO.deleteComment(commentNumber, memberNumber,
				memberNickName);
		if (checkState == 0) {
			return false;
		}
		return true;
	}

	
	//댓글 수정
	public boolean updateComment(int commentNumber, String commentContent,
			String memberNickName) {
		MemberVO findMember = memberDAO.findMemberByNickName(memberNickName);
		if (findMember != null) {
			int checkState = commentDAO.updateComment(commentNumber,
					commentContent, findMember.getMemberNumber(),
					findMember.getMemberNickName());
			if (checkState != 0) {
				return true;
			}
		}
		return false;
	}

	//글에대한 댓글 보여주기.
	public List<CommentVO> showAllCommentByArticle(int articleNumber) {
		return commentDAO.findAllCommentByArticle(articleNumber);
	}
}
