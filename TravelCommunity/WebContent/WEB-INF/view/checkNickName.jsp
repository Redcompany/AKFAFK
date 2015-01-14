<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection, java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<%!Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;

	String databaseURL = "jdbc:mysql://localhost/TravelCommunity";
	String username = "root";
	String password = "1234";

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setConnection() {
		try {
			conn = DriverManager.getConnection(databaseURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>
<%
	String nickname = request.getParameter("nickname");
	try {
		this.setConnection();
		String sqlStr = "select * from member where member_nickname=?";
		pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, nickname);
		rset = pstmt.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>체크 닉네임</title>
<script>
	function checkNickNameClose(nickname) {
		opener.writeForm.nickname.value = nickname;
		window.close();
		opener.writeForm.email.focus();
	}
</script>
<style>
body {
	font-size: 12pt
}
</style>
</head>
<body>
	<form action="action/checkNickName" method="post">
		<%
			try {
				if (rset.next() || (nickname == null)) {
		%>
		현재 [
		<%=nickname%>
		 ] 사용불가능<br></br> 
		<%
			} else {
		%>
		현재 [
		<%=nickname%> ] 사용가능 <input type="button" value="현재 닉네임 선택"
			onclick="javascript:checkNickNameClose('<%=nickname%>')">
		<%
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		%>

	</form>
</body>
</html>
