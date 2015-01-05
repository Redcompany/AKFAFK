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

public class MySqlArticleDAO implements ArticleDAO {
	String databaseURL = "jdbc:mysql://localhost/TravelCommunity";
	String username = "root";
	String password = "1234";
	
	public List<ArticleVO> findAllArticleByContinent(String continent) {
		Connection conn = null;
		Statement stmt = null;

		ArrayList<ArticleVO> continentArticleList = new ArrayList<ArticleVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM article where article_continent='"
					+ continent + "'";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int articleNumber = rset.getInt("article_number");
				String articleTitle = rset.getString("article_title");
				String articleContent = rset.getString("article_content");
				String articleCountry = rset.getString("article_country");
				Date articleDate = rset.getDate("article_date");
				int memberNumber = rset.getInt("member_number");
				int articleRecommendCount = rset
						.getInt("article_recommend_count");
				int articleViewCount = rset.getInt("article_view_count");
				String memberNickName = rset.getString("member_nickname");
				continentArticleList.add(new ArticleVO(articleNumber,
						articleTitle, continent, articleCountry, articleDate,
						articleRecommendCount, articleViewCount,
						articleContent, memberNumber, memberNickName));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return continentArticleList;
	}

	public List<ArticleVO> findAllArticleByCountry(String country) {
		Connection conn = null;
		Statement stmt = null;

		ArrayList<ArticleVO> countrytArticleList = new ArrayList<ArticleVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM article where article_country='"
					+ country + "'";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int articleNumber = rset.getInt("article_number");
				String articleTitle = rset.getString("article_title");
				String articleContent = rset.getString("article_content");
				String articleContinent = rset.getString("article_continent");
				Date articleDate = rset.getDate("article_date");
				int memberNumber = rset.getInt("member_number");
				int articleRecommendCount = rset
						.getInt("article_recommend_count");
				int articleViewCount = rset.getInt("article_view_count");
				String memberNickName = rset.getString("member_nickname");
				countrytArticleList.add(new ArticleVO(articleNumber,
						articleTitle, articleContinent, country, articleDate,
						articleRecommendCount, articleViewCount,
						articleContent, memberNumber, memberNickName));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return countrytArticleList;
	}

	public ArticleVO showSelectArticle(int articleNumber) {
		Connection conn = null;
		Statement stmt = null;
		ArticleVO findSelectArticle = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM article where article_number="
					+ articleNumber;
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) {
				String articleTitle = rset.getString("article_title");
				String articleContent = rset.getString("article_content");
				String articleContinent = rset.getString("article_continent");
				String articleCountry = rset.getString("article_country");
				Date articleDate = rset.getDate("article_date");
				int memberNumber = rset.getInt("member_number");
				int articleRecommendCount = rset
						.getInt("article_recommend_count");
				int articleViewCount = rset.getInt("article_view_count");
				String memberNickName = rset.getString("member_nickname");

				findSelectArticle = new ArticleVO(articleNumber, articleTitle,
						articleContinent, articleCountry, articleDate,
						articleRecommendCount, articleViewCount,
						articleContent, memberNumber, memberNickName);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return findSelectArticle;
	}

	public int addArticle(String title, String continent, String country,
			String content, int memberNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		Date nowDate = new Date();
		SimpleDateFormat sdfNowDate = new SimpleDateFormat("yyyyMMdd");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "INSERT INTO article "
					+ "(article_title, article_continent, article_country, article_content, article_date, member_number, member_nickname)"
					+ " VALUES ( '" + title + "' , '" + continent + "' , '"
					+ country + "' , '" + content + "' , "
					+ sdfNowDate.format(nowDate) + " , " + memberNumber + ", '"
					+ memberNickName + "');";

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}

	public int updateArticle(int articleNumber, String articleContent,
			int memberNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		ArticleVO checkedArticle = showSelectArticle(articleNumber);

		if (checkedArticle.getMemberNumber() == memberNumber
				&& checkedArticle.getMemberNickName().equals(memberNickName)) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(databaseURL, username,
						password);
				stmt = conn.createStatement();

				String sqlStr = "UPDATE article set article_content='"
						+ articleContent + "' where article_number="
						+ articleNumber;
				stateCheck = stmt.executeUpdate(sqlStr);
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex2) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex2);
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(MySqlArticleDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return stateCheck;
	}

	public int deleteArticle(int articleNumber, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		ArticleVO checkedArticle = showSelectArticle(articleNumber);

		if (checkedArticle.getMemberNickName().equals(memberNickName)) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(databaseURL, username,
						password);
				stmt = conn.createStatement();
				String sqlStr = "delete from article where article_number="
						+ articleNumber;
				stateCheck = stmt.executeUpdate(sqlStr);
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex2) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex2);
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(MySqlArticleDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return stateCheck;
	}

	public int deleteArticle(String memberNickName) { // 멤버삭제전
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "delete from article where member_nickname="
					+ memberNickName;
			stateCheck = stmt.executeUpdate(sqlStr);
		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}

	public List<ArticleVO> findBestArticle() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<ArticleVO> rankArticles = new ArrayList<ArticleVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from article order by article_recommend_count desc limit 5";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) {
				int articleNumber = rset.getInt("article_number");
				String articleTitle = rset.getString("article_title");
				String articleContent = rset.getString("article_content");
				String articleContinent = rset.getString("article_continent");
				String articleCountry = rset.getString("article_country");
				Date articleDate = rset.getDate("article_date");
				int memberNumber = rset.getInt("member_number");
				int articleRecommendCount = rset
						.getInt("article_recommend_count");
				int articleViewCount = rset.getInt("article_view_count");
				String memberNickName = rset.getString("member_nickname");

				rankArticles.add(new ArticleVO(articleNumber, articleTitle,
						articleContinent, articleCountry, articleDate,
						articleRecommendCount, articleViewCount,
						articleContent, memberNumber, memberNickName));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return rankArticles;
	}

	public List<ArticleVO> findBestArticleByContinent(String continent) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<ArticleVO> rankArticles = new ArrayList<ArticleVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from article where article_continent= '"
					+ continent
					+ "' order by article_recommend_count desc limit 5";

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) {
				int articleNumber = rset.getInt("article_number");
				String articleTitle = rset.getString("article_title");
				String articleContent = rset.getString("article_content");
				String articleContinent = rset.getString("article_continent");
				String articleCountry = rset.getString("article_country");
				Date articleDate = rset.getDate("article_date");
				int memberNumber = rset.getInt("member_number");
				int articleRecommendCount = rset
						.getInt("article_recommend_count");
				int articleViewCount = rset.getInt("article_view_count");
				String memberNickName = rset.getString("member_nickname");

				rankArticles.add(new ArticleVO(articleNumber, articleTitle,
						articleContinent, articleCountry, articleDate,
						articleRecommendCount, articleViewCount,
						articleContent, memberNumber, memberNickName));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlArticleDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlArticleDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return rankArticles;
	}
}