<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.AFK.travel56.service.ArticleService"%>
<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>TOP</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/css/ripples.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/css/material.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/css/material-wfont.min.css">
<link href="//fezvrasta.github.io/snackbarjs/snackbar.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<br>
	<table align="center" width="85%">
		<tr>
			<%
				String logo = request.getContextPath() + "/devImg/map.jpg";
			%>
			<td align="center" width="5%"><a href="home"> <img id='logo'
					src=<%=logo%>>
			</a></td>

			<td>

				<div class="navbar navbar-default">
					<div class="navbar-collapse collapse navbar-responsive-collapse">
						<ul class="nav navbar-nav">

							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">유럽<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="continentChoose" href="showArticles">유럽</a></li>
									<%
										Set<String> europeSet= new HashSet<String>();
										ArticleService articleService= new ArticleService();
										List<ArticleVO> findArticleContinent=articleService.showAllArticleByContinent("유럽");
										
										for(ArticleVO country:findArticleContinent){
											europeSet.add(country.getArticleCountry());
										}
																																												                                                   
										for (Iterator iter = europeSet.iterator(); iter.hasNext();) {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}
									%>
								</ul></li>
							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">아시아<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="continentChoose" href="showArticles">아시아</a></li>
									<%
										Set<String> asiaSet= new HashSet<String>();
									findArticleContinent=articleService.showAllArticleByContinent("아시아");
	                                 
		                              for(ArticleVO country:findArticleContinent){
		                                 asiaSet.add(country.getArticleCountry());
		                              }
		                                                   
		                              for (Iterator iter = asiaSet.iterator(); iter.hasNext();) {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}
									%>
								</ul></li>
							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">아프리카<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="continentChoose" href="showArticles">아프리카</a></li>
									<%
										Set<String> afreecaSet= new HashSet<String>();
									findArticleContinent=articleService.showAllArticleByContinent("아프리카");
	                                 
		                              for(ArticleVO country:findArticleContinent){
		                                 afreecaSet.add(country.getArticleCountry());
		                              }
		                                                   
		                              for (Iterator iter = afreecaSet.iterator(); iter.hasNext();) {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}
									%>
								</ul></li>
							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">북아메리카<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="continentChoose" href="showArticles">북아메리카</a></li>
									<%
										Set<String> northAmericaSet= new HashSet<String>();
									findArticleContinent=articleService.showAllArticleByContinent("북아메리카");
	                                 
		                              for(ArticleVO country:findArticleContinent){
		                                 northAmericaSet.add(country.getArticleCountry());
		                              }
		                                                   
		                              for (Iterator iter = northAmericaSet.iterator(); iter.hasNext();)
		                              {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}
									%>
								</ul></li>

							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">남아메리카<b
									class="caret"></b></a>
								<ul class="dropdown-menu">

									<li><a class="continentChoose" href="showArticles">남아메리카</a></li>

									<%
										Set<String> southAmericaSet= new HashSet<String>();

		                              findArticleContinent=articleService.showAllArticleByContinent("남아메리카");
		                                 
		                              for(ArticleVO country:findArticleContinent){
		                                 southAmericaSet.add(country.getArticleCountry());
		                              }
		                                                   
		                              for (Iterator iter = southAmericaSet.iterator(); iter.hasNext();)
		                              {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}/* onclick="javascript:countryClick()" */
									%>
								</ul></li>

							<li class="dropdown"><a href="javascript:void(0)"
								class="dropdown-toggle" data-toggle="dropdown">오세아니아<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a class="continentChoose" href="showArticles">오세아니아</a></li>
									<%
										Set<String> oceaniaSet= new HashSet<String>();

		                              findArticleContinent=articleService.showAllArticleByContinent("오세아니아");
		                                 
		                              for(ArticleVO country:findArticleContinent){
		                                 oceaniaSet.add(country.getArticleCountry());
		                              }
		                                                   
		                              for (Iterator iter = oceaniaSet.iterator(); iter.hasNext();)
		                              {
									%>
									<li><a class="countryChoose" href="showArticles"><%=iter.next()%></a></li>
									<%
										}
									%>>
								</ul></li>
						</ul>

					</div>
				</div>
			</td>

			<td><table align="center">
					<tr>
							<c:if test="${sessionScope.loginsession.memberName == null}">
								<th>
								<form><input class="id" name="id" type="text" size="10"
									maxlength="12" placeholder="아이디"><br> <input
									class="pass" name="pass" type="password" size="10"
									maxlength="12" placeholder="비밀번호"> <input type="submit"
									name="todo" value="로그인" onclick="jacascript:check"></form></th>
									<tr>
							<td colspan="2"><a class="asd" href="register" id="회원가입">회원가입</a>
							<a class="find" href="findIDPassword" id="찾기">ID/PW 찾기</a></td>
					</tr>
							</c:if>
							<c:if test="${sessionScope.loginsession.memberName != null}">
									<table align="center">
										<tr>
											<td colspan="2"><b>${sessionScope.loginsession.memberName}</b>
												님 환영합니다.</td>
										</tr>
										<tr>
											<td>
												<form name="MyPage" action="<c:url value='/action/mypage'/>"
                                    			method="POST">
                                    				<input class="logout" name="todo" type="submit" value="My Page">
                                				</form>
											</td>
											<td>
												<form name="logout" action="<c:url value='/action/home'/>" method="POST">
												<input type="submit" name="todo" value="로그아웃">
												</form>
											</td>
										</tr>
									</table>
							</c:if>
					</tr>
				</table></td>
		</tr>
	</table>

	<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		(function() {

			var $button = $(
					"<div id='source-button' class='btn btn-primary btn-xs'>&lt; &gt;</div>")
					.click(
							function() {
								var index = $('.bs-component').index(
										$(this).parent());
								$.get(window.location.href, function(data) {
									var html = $(data).find('.bs-component')
											.eq(index).html();
									html = cleanSource(html);
									$("#source-modal pre").text(html);
									$("#source-modal").modal();
								})

							});

			$('.bs-component [data-toggle="popover"]').popover();
			$('.bs-component [data-toggle="tooltip"]').tooltip();

			$(".bs-component").hover(function() {
				$(this).append($button);
				$button.show();
			}, function() {
				$button.hide();
			});

			function cleanSource(html) {
				var lines = html.split(/\n/);

				lines.shift();
				lines.splice(-1, 1);

				var indentSize = lines[0].length - lines[0].trim().length, re = new RegExp(
						" {" + indentSize + "}");

				lines = lines.map(function(line) {
					if (line.match(re)) {
						line = line.substring(indentSize);
					}

					return line;
				});

				lines = lines.join("\n");

				return lines;
			}

			$(".icons-material .icon").each(
					function() {
						$(this).after(
								"_$ta_$ta_$tag_"
										+ $(this).attr("class").replace(
												"icon ", "") + "_$tag__");
					});

		})();
	</script>
	<script src="http://localhost:9999/TravelCommunity/js/ripples.min.js"></script>
	<script src="http://localhost:9999/TravelCommunity/js/material.min.js"></script>
	<script src="//fezvrasta.github.io/snackbarjs/dist/snackbar.min.js"></script>

	<script
		src="//cdnjs.cloudflare.com/ajax/libs/noUiSlider/6.2.0/jquery.nouislider.min.js"></script>
	<script>
		$(function() {
			$.material.init();
			$(".shor").noUiSlider({
				start : 40,
				connect : "lower",
				range : {
					min : 0,
					max : 100
				}
			});

			$(".svert").noUiSlider({
				orientation : "vertical",
				start : 40,
				connect : "lower",
				range : {
					min : 0,
					max : 100
				}
			});
		});
		$("a.countryChoose").click(function() {
			var country = "showArticles?todo=doing&country=" + $(this).text();
			$(this).attr('href', country);
		});
		$("a.continentChoose").click(
				function() {
					var continent = "showArticles?todo=doing&continent="
							+ $(this).text();
					$(this).attr('href', continent);
				});
	</script>
</body>
</html>