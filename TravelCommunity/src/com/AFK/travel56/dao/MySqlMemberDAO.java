package com.AFK.travel56.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlMemberDAO implements MemberDAO {

	String databaseURL = "jdbc:mysql://localhost/TravelCommunity";
	String username = "root";
	String password = "1234";

	public int addMember(String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberBirth, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");

		try {
			Date birthDate = sdFormat.parse(memberBirth);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "INSERT INTO member "
					+ "(member_id, member_password, member_gender, member_email, member_name, member_birth, member_nickname)"
					+ " VALUES ( '" + memberID + "' , '" + memberPW + "' , "
					+ memberGender + " , '" + memberEmail + "' , '"
					+ memberName + "' , " + sdFormat.format(birthDate) + " , '"
					+ memberNickName + "');";

			stateCheck = stmt.executeUpdate(sqlStr);

		} catch (ParseException ex3) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex3);
		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	} // end addMember()

	public int deleteMember(String memberID, String memberPW) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			MemberVO memberCheck = findMemberByID(memberID);
			if (memberID.equals(memberCheck.getMemberID())
					&& memberPW.equals(memberCheck.getMemberPW())) {// &&memberPW.equls()
				String sqlStr = "UPDATE member SET member_id = null where member_id ='"
						+ memberID + "';";// join
				stateCheck = stmt.executeUpdate(sqlStr);
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return stateCheck;
	} // end deleteMember()

	public List<MemberVO> findAllMembers() {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM member";
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int memberNumber = rset.getInt("member_number");
				String memberID = rset.getString("member_id");
				String memberPW = rset.getString("member_password");
				boolean memberGender = rset.getBoolean("member_gender");
				String memberEmail = rset.getString("member_email");
				String memberName = rset.getString("member_name");
				String memberPhone = rset.getString("member_phone");
				String memberBirth = rset.getString("member_birth");
				String memberNickName = rset.getString("member_nickname");

				memberList.add(new MemberVO(memberNumber, memberID, memberPW,
						memberGender, memberEmail, memberName, memberPhone,
						memberBirth, memberNickName));
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberList;
	} // end findAllMembers()

	public MemberVO findMemberByID(String memberID) {
		Connection conn = null;
		Statement stmt = null;
		MemberVO memberVO = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM member where member_id = '"
					+ memberID + "'";
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int membersNumber = rset.getInt("member_number");
				String membersID = rset.getString("member_id");
				String membersPW = rset.getString("member_password");
				boolean membersGender = rset.getBoolean("member_gender");
				String membersEmail = rset.getString("member_email");
				String membersName = rset.getString("member_name");
				String membersPhone = rset.getString("member_phone");
				String membersBirth = rset.getString("member_birth");
				String membersNickName = rset.getString("member_nickname");

				memberVO = new MemberVO(membersNumber, membersID, membersPW,
						membersGender, membersEmail, membersName, membersPhone,
						membersBirth, membersNickName);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberVO;
	} // end findMemberByID()

	public int updateMember(String memberID, String memberPW,
			boolean memberGender, String memberEmail, String memberName,
			String memberBirth, String memberPhone, String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		int stateCheck = 0;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthDate = sdFormat.parse(memberBirth);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			String sqlStr = "UPDATE member set member_id='" + memberID
					+ "' , member_password='" + memberPW + "' , member_gender="
					+ memberGender + ", member_email= '" + memberEmail
					+ "' , member_name='" + memberName + "', member_birth= '"
					+ sdFormat.format(birthDate) + "', member_phone= '"
					+ memberPhone + "' where + member_nickname= '"
					+ memberNickName + "';";

			stateCheck = stmt.executeUpdate(sqlStr);
		} catch (ParseException ex3) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex3);
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
	} // end updateMember()

	public MemberVO findMemberByNickName(String memberNickName) {
		Connection conn = null;
		Statement stmt = null;
		MemberVO memberVO = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM member where member_nickname = '"
					+ memberNickName + "'";
			ResultSet rset = stmt.executeQuery(sqlStr);

			while (rset.next()) { // list all the authors
				int membersNumber = rset.getInt("member_number");
				String membersID = rset.getString("member_id");
				String membersPW = rset.getString("member_password");
				boolean membersGender = rset.getBoolean("member_gender");
				String membersEmail = rset.getString("member_email");
				String membersName = rset.getString("member_name");
				String membersPhone = rset.getString("member_phone");
				String membersBirth = rset.getString("member_birth");
				String membersNickName = rset.getString("member_nickname");

				memberVO = new MemberVO(membersNumber, membersID, membersPW,
						membersGender, membersEmail, membersName, membersPhone,
						membersBirth, membersNickName);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberVO;
	} // end findMemberByNickName()

	public MemberVO memberLogin(String memberID, String memberPW) {
		Connection conn = null;
		Statement stmt = null;
		MemberVO memberVO = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();

			MemberVO memberCheck = findMemberByID(memberID);
			if (memberID.equals(memberCheck.getMemberID())
					&& memberPW.equals(memberCheck.getMemberPW())) {// &&memberPW.equls()
				String sqlStr = "SELECT * FROM member where member_id = '"
						+ memberID + "';";

				ResultSet rset = stmt.executeQuery(sqlStr);

				while (rset.next()) { // list all the authors
					int membersNumber = rset.getInt("member_number");
					String membersID = rset.getString("member_id");
					String membersPW = rset.getString("member_password");
					boolean membersGender = rset.getBoolean("member_gender");
					String membersEmail = rset.getString("member_email");
					String membersName = rset.getString("member_name");
					String membersPhone = rset.getString("member_phone");
					String membersBirth = rset.getString("member_birth");
					String membersNickName = rset.getString("member_nickname");

					memberVO = new MemberVO(membersNumber, membersID,
							membersPW, membersGender, membersEmail,
							membersName, membersPhone, membersBirth,
							membersNickName);
				}
			} else {
				System.out.println("입력된 정보를 다시 확인해주세요!");
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberVO;
	} // end memberLogin()

	public MemberVO findMemberByNameBirthNickname(String memberName,
			String memberBirth, String memberNickname) {
		Connection conn = null;
		Statement stmt = null;
		MemberVO memberVO = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from member where member_name= '"
					+ memberName + "' and member_birth= '" + memberBirth
					+ "' and member_nickname= '" + memberNickname + "'";
			ResultSet rset = stmt.executeQuery(sqlStr);
			while (rset.next()) { // list all the authors
				int membersNumber = rset.getInt("member_number");
				String membersID = rset.getString("member_id");
				String membersPW = rset.getString("member_password");
				boolean membersGender = rset.getBoolean("member_gender");
				String membersEmail = rset.getString("member_email");
				String membersName = rset.getString("member_name");
				String membersPhone = rset.getString("member_phone");
				String membersBirth = rset.getString("member_birth");
				String membersNickName = rset.getString("member_nickname");

				memberVO = new MemberVO(membersNumber, membersID, membersPW,
						membersGender, membersEmail, membersName, membersPhone,
						membersBirth, membersNickName);
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberVO;
	}

	public MemberVO findMemberByIDNameBirth(String memberID, String memberName,
			String memberBirth) {
		Connection conn = null;
		Statement stmt = null;
		MemberVO memberVO = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(databaseURL, username, password);
			stmt = conn.createStatement();
			String sqlStr = "select * from member where member_name= '"
					+ memberName + "' and member_birth= '" + memberBirth
					+ "' and member_id= '" + memberID + "'";
			ResultSet rset = stmt.executeQuery(sqlStr);
			while (rset.next()) { // list all the authors
				int membersNumber = rset.getInt("member_number");
				String membersID = rset.getString("member_id");
				String membersPW = rset.getString("member_password");
				boolean membersGender = rset.getBoolean("member_gender");
				String membersEmail = rset.getString("member_email");
				String membersName = rset.getString("member_name");
				String membersPhone = rset.getString("member_phone");
				String membersBirth = rset.getString("member_birth");
				String membersNickName = rset.getString("member_nickname");

				memberVO = new MemberVO(membersNumber, membersID, membersPW,
						membersGender, membersEmail, membersName, membersPhone,
						membersBirth, membersNickName);
			}

		} catch (SQLException ex) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex2) {
			Logger.getLogger(MySqlMemberDAO.class.getName()).log(Level.SEVERE,
					null, ex2);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				Logger.getLogger(MySqlMemberDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return memberVO;
	}
}
