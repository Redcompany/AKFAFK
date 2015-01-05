package com.AFK.travel56.dao;

import java.util.List;

public interface CommentDAO {

	public CommentVO findCommentByCommentNumber(int commentNumber);

	public List<CommentVO> findAllCommentByArticle(int articleNumber);

	public int addComment(String commentContent, int memberNumber,
			String memberNickName, int articleNumber);

	public int addCommentOfComment(String commentContent, int memberNumber,
			String memberNickName, int articleNumber, int parentComment);

	public int updateComment(int commentNumber, String commentContent, int memberNumber, String memberNickName);

	public int deleteComment(int commentNumber, int memberNumber,
			String memberNickName);

	public int deleteCommentByMember(int memberNumber, String memberNickName);

	public int deleteCommentByArticle(int articleNumber);
}
