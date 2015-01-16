<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8"/>
<title>오륙닷컴에 오신걸 혼영합니다!</title>
<link rel="stylesheet" type="text/css" href="http://localhost:9999/TravelCommunity/css/styles.css">
</head>
<body class="skippage">

<h1 style ="font-family: verdana"> 56.com</h1>

    <a class="skip" href="action/home">s k i p</a>

	<form name ="checkoutForm" action="action/showArticles" method="POST">
	<input type="submit" name="continent" value="아프리카">
	<input type="submit" name="continent" value="남아메리카">
	<input type="submit" name="continent" value="북아메리카">
	<input type="submit" name="continent" value="유럽">
	<input type="submit" name="continent" value="아시아">
	<input type="submit" name="continent" value="오세아니아">
    </form>

</body>
</html>