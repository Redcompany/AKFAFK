<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8"/>
<title>오륙닷컴에 오신걸 환영합니다!</title>
<link rel="stylesheet" type="text/css" href="http://localhost:9999/TravelCommunity/css/styles.css">
</head>
<body class="skippage">

<h1 style ="font-family: verdana"> 56.com</h1>

    <a class="skip" href="action/home">E N T E R</a>

	<form name ="checkoutForm" action="action/showArticles" method="POST">
	<a class="afreeca"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="아프리카"></a>
	<a class="s_america"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="남아메리카"></a>
	<a class="n_america"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="북아메리카"></a>
	<a class="europe"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="유럽"></a>
	<a class="asia"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="아시아"></a>
	<a class="oceania"><input type="hidden" name="todo" value="doing"><input type="submit" name="continent" value="오세아니아"></a>
    </form>

</body>
</html>