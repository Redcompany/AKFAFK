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
	String id = request.getParameter("id");
	try {
		this.setConnection();
		String sqlStr = "select * from member where member_id=?";
		pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, id);
		rset = pstmt.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>체크 아이디</title>
<script>
	function checkIDClose(id) {
		opener.writeForm.id.value = id;
		window.close();
		opener.writeForm.pass.focus();
	}
</script>
<style>
body {
	font-size: 12pt
}
</style>
</head>
<body>
	<form action="action/checkID" method="post">
		<%
			try {
				if (rset.next() || (id == null)) {
		%>
		현재 [
		<%=id%>
		 ] 사용불가능<br></br> 
		<%
			} else {
		%>
		현재 [ 
		<%=id%> ] 사용가능 <input
			type="button" value="현재 아이디 선택"
			onclick="javascript:checkIDClose('<%=id%>')">
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
