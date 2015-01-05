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

public class MySqlFileDAO implements FileDAO {
	String databaseURL = "jdbc:mysql://localhost/TravelCommunity";
	String username = "root";
	String password = "1234";

	public List<FileVO> findAllFile() {
		Connection conn = null;
		Statement stmt = null;

		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from `file`";
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int fileNumber = rset.getInt("file_number");
				String fileName = rset.getString("file_name");
				int fileArticleNumber = rset.getInt("article_number");

				fileList.add(new FileVO(fileNumber, fileName, fileArticleNumber));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlFileDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return fileList;
	}

	public List<FileVO> findAllFileByArticle(int articleNumber) {
		Connection conn = null;
		Statement stmt = null;

		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM `file` where article_continent="
					+ articleNumber;

			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int fileNumber = rset.getInt("file_number");
				String fileName = rset.getString("file_name");
				int fileArticleNumber = rset.getInt("article_number");

				fileList.add(new FileVO(fileNumber, fileName, fileArticleNumber));
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlFileDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return fileList;
	}

	public int addFile(String fileName, int articleNumber) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		Date nowDate = new Date();
		SimpleDateFormat sdfNowDate = new SimpleDateFormat("yyyyMMdd");
		List<FileVO> countFileList = this.findAllFile();

		if (fileName != null) {
			String changeFileName = sdfNowDate.format(nowDate) + articleNumber
					+ countFileList.size();
			fileName = changeFileName;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "insert into `file`(file_name,article_number) valus ('"
					+ fileName + "', " + articleNumber + ")";
			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlFileDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}

	public int deleteFile(String fileName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "update `file` set file_name=null where file_name=null";

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (SQLException ex) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlFileDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlFileDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	}
}
