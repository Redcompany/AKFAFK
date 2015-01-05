package com.AFK.travel56.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlCommentDAO implements CommentDAO {

	String databaseURL = "jdbc:mysql://localhost/TravelCommunity";
	String username = "root";
	String password = "1234";

	public List<CommentVO> findAllCommentByArticle(int articleNumber) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<CommentVO> commentList = new ArrayList<CommentVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM Comment WHERE article_number="
					+ articleNumber;
			ResultSet rset = stmt.executeQuery(sqlStr);
			while (rset.next()) { // list all the authors
				int commentNumber = rset.getInt("comment_number");
				Date commentDate = rset.getDate("comment_date");
				String commentContent = rset.getString("comment_content");
				int memberNumber = rset.getInt("member_number");
				String memberNickName = rset.getString("member_nickname");
				int parentComment = rset.getInt("parent_comment");

				commentList.add(new CommentVO(commentNumber, commentDate,
						commentContent,memberNumber,memberNickName, articleNumber,
						parentComment));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return commentList;
	}

	public CommentVO findCommentByCommentNumber(int commentNumber) {
		Connection conn = null;
		Statement stmt = null;
		CommentVO findComment = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM Comment WHERE comment_number="
					+ commentNumber;
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				Date commentDate = rset.getDate("comment_date");
				String commentContent = rset.getString("comment_content");
				int memberNumber = rset.getInt("member_number");
				String memberNickName = rset.getString("member_nickname");
				int articleNumber = rset.getInt("article_number");
				int parentComment = rset.getInt("parent_comment");

				findComment = new CommentVO(commentNumber, commentDate, commentContent, memberNumber, memberNickName, articleNumber, parentComment);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return findComment;
	}

	public int addComment(String commentContent, int memberNumber, String memberNickName,
			int articleNumber) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		Date nowDate = new Date();
		SimpleDateFormat sdfNowDate = new SimpleDateFormat("yyyyMMdd");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "INSERT INTO comment"
					+ "(comment_date, comment_content, member_number, member_nickname, article_number)"
					+ " VALUES ( " + sdfNowDate.format(nowDate) + " , '"
					+ commentContent + "' , " + memberNumber + " , '" + memberNickName + "' , "
					+ articleNumber + ");";
			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	} // end addComment()

	public int addCommentOfComment(String commentContent, int memberNumber, String memberNickName, 
			int articleNumber, int parentComment) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		Date nowDate = new Date();
		SimpleDateFormat sdfNowDate = new SimpleDateFormat("yyyyMMdd");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "INSERT INTO comment"
					+ "(comment_date, comment_content, member_number, member_nickname, article_number, parent_comment)"
					+ " VALUES ( " + sdfNowDate.format(nowDate) + " , '"
					+ commentContent + "' , " + memberNumber + " , '" + memberNickName + "' , "
					+ articleNumber + " , " + parentComment + ");";
			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	} // end addComment()

	public int updateComment(int commentNumber, String commentContent, int memberNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "UPDATE comment SET comment_content ='"
					+ commentContent + "' WHERE comment_number = "
					+ commentNumber;

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	} // end updateComment()

	public int deleteComment(int commentNumber, int memberNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		CommentVO findComment = findCommentByCommentNumber(commentNumber);

		if (findComment.getMemberNickName().equals(memberNickName)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(databaseURL, username,
						password);
				stmt = conn.createStatement();
				String sqlStr = "DELETE FROM comment WHERE comment_number = "
						+ commentNumber + ";";

				stateCheck = stmt.executeUpdate(sqlStr);

			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex2) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex2);
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(MySqlCommentDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return stateCheck;
	}

	public int deleteCommentByMember(int memberNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "DELETE FROM comment WHERE member_number = "
					+ memberNumber + " , '" + memberNickName + "';";

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}
	public int deleteCommentByArticle (int articleNumber) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "DELETE FROM comment WHERE article_number = "
					+ articleNumber + ";";

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlCommentDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlCommentDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}
}