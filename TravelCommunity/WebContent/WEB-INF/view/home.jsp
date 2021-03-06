<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>AFK_travel56에 온 것을 환영해요~</title>
</head>
<body>

   <%@include file="always/top.jsp"%>

   <%
      int a = 1;
      int b = 1;
      int c = 1;
      int d = 1;
      int e = 1;
      int f = 1;
      int g = 1;
      int h = 1;
   %>   
   <table width="85%" align="center" border="0">
      <tr>
         <td>
         <div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="cente">

               <th class="totalbest" colspan=2>전체 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="50">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="AllBestArticle" items="${showBestArticle}">
                  <tr>
                     <td><%=a++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${AllBestArticle.getArticleNumber()}">${AllBestArticle.articleTitle}</a></td>
                     <td>${AllBestArticle.memberNickName}</td>
                     <td>${AllBestArticle.articleDate}</td>
                     <td>${AllBestArticle.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table>
            </div>
         </td>

         <td><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">
               <th class="totalbest" colspan=2>공지사항</th>
               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByNotice"
                  items="${findBestArticleByNotice}">
                  <tr>
                     <td><%=b++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByNotice.getArticleNumber()}">${BestArticleByNotice.articleTitle}</a></td>
                     <td>${BestArticleByNotice.memberNickName}</td>
                     <td>${BestArticleByNotice.articleDate}</td>
                     <td>${BestArticleByNotice.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
      </tr>
      <tr>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>유럽 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByEurope"
                  items="${findBestArticleByEurope}">
                  <tr>
                     <td><%=c++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByEurope.getArticleNumber()}">${BestArticleByEurope.articleTitle}</a></td>
                     <td>${BestArticleByEurope.memberNickName}</td>
                     <td>${BestArticleByEurope.articleDate}</td>
                     <td>${BestArticleByEurope.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>아시아 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByAsia" items="${findBestArticleByAsia}">
                  <tr>
                     <td><%=d++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByAsia.getArticleNumber()}">${BestArticleByAsia.articleTitle}</a></td>
                     <td>${BestArticleByAsia.memberNickName}</td>
                     <td>${BestArticleByAsia.articleDate}</td>
                     <td>${BestArticleByAsia.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
      </tr>
      <tr>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>아프리카 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByAfrica"
                  items="${findBestArticleByAfrica}">
                  <tr>
                     <td><%=e++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByAfrica.getArticleNumber()}">${BestArticleByAfrica.articleTitle}</a></td>
                     <td>${BestArticleByAfrica.memberNickName}</td>
                     <td>${BestArticleByAfrica.articleDate}</td>
                     <td>${BestArticleByAfrica.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>북아메리카 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByNorthAmerican"
                  items="${findBestArticleByNorthAmerican}">
                  <tr>
                     <td><%=f++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByNorthAmerican.getArticleNumber()}">${BestArticleByNorthAmerican.articleTitle}</a></td>
                     <td>${BestArticleByNorthAmerican.memberNickName}</td>
                     <td>${BestArticleByNorthAmerican.articleDate}</td>
                     <td>${BestArticleByNorthAmerican.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
      </tr>
      <tr>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>남아메리카 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleBySouthAmerican"
                  items="${findBestArticleBySouthAmerican}">
                  <tr>
                     <td><%=g++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleBySouthAmerican.getArticleNumber()}">${BestArticleBySouthAmerican.articleTitle}</a></td>
                     <td>${BestArticleBySouthAmerican.memberNickName}</td>
                     <td>${BestArticleBySouthAmerican.articleDate}</td>
                     <td>${BestArticleBySouthAmerican.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
         <td width="50%"><div class="sample shadow-z-3">
            <table width="95%" height="auto" cellpadding="0" cellspacing="1"
               border="0" id="Table" align="center">

               <th class="totalbest" colspan=2>오세아니아 BEST</th>

               <tr>
                  <th width="70">Number</th>
                  <th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
                  <th width="100">I D</th>
                  <th width="110">날 짜</th>
                  <th width="80">추천수</th>
               </tr>
               <c:forEach var="BestArticleByOceania"
                  items="${findBestArticleByOceania}">
                  <tr>
                     <td><%=h++%></td>
                     <td><a
                        href="readArticle?todo=read&idx=${BestArticleByOceania.getArticleNumber()}">${BestArticleByOceania.articleTitle}</a></td>
                     <td>${BestArticleByOceania.memberNickName}</td>
                     <td>${BestArticleByOceania.articleDate}</td>
                     <td>${BestArticleByOceania.articleRecommendCount}</td>
                  </tr>
               </c:forEach>
            </table></div>
         </td>
      </tr>
   </table>

   <%@include file="always/bottom.jsp"%>

</body>
</html>