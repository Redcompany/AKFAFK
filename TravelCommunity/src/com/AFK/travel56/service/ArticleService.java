package com.AFK.travel56.service;

import java.util.List;

import com.AFK.travel56.dao.ArticleDAO;
import com.AFK.travel56.dao.ArticleRecommandVO;
import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.CommentDAO;
import com.AFK.travel56.dao.FileDAO;
import com.AFK.travel56.dao.MemberDAO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.dao.MySqlArticleDAO;
import com.AFK.travel56.dao.MySqlCommentDAO;
import com.AFK.travel56.dao.MySqlFileDAO;
import com.AFK.travel56.dao.MySqlMemberDAO;

public class ArticleService {
   ArticleDAO articleDAO = new MySqlArticleDAO();
   MemberDAO memberDAO = new MySqlMemberDAO();

   public List<ArticleVO> findAllArticles() {
      List<ArticleVO> articleList = articleDAO.findAllArticle();
      return articleList;
   }
   
   public ArticleVO findLastArticle(){
	   ArticleVO lastArticle=articleDAO.findLastArticle();
	   return lastArticle;
   }

   // 글 등록
   public boolean registerArticle(String title, String continent,
         String country, String content, String memberNickName) {
      MemberVO findMember = memberDAO.findMemberByNickName(memberNickName);
      if (findMember != null) {
         int checkState = articleDAO.addArticle(title, continent, country,
               content, findMember.getMemberNumber(),
               findMember.getMemberNickName());
         if (checkState != 0) {
            return true;
         }
      }
      return false;
   }

   // 글 삭제
   public boolean deleteArticle(int articleNumber, String memberNickName) {
      CommentDAO commentDAO = new MySqlCommentDAO();
      FileDAO fileDAO= new MySqlFileDAO();
      fileDAO.deleteFileByArticleNumber(articleNumber);
      commentDAO.deleteCommentByArticle(articleNumber);
      articleDAO.deleteRecommand(articleNumber);
      int checkState = articleDAO
            .deleteArticle(articleNumber, memberNickName);
      if (checkState == 0) {
         return false;
      }
      return true;
   }

   // 글 변경
   public ArticleVO updateArticle(int articleNumber, String articleTilte,
         String articleContent, String memberNickName) {
      MemberVO findMember = memberDAO.findMemberByNickName(memberNickName);
      if (findMember != null) {
         articleDAO.updateArticle(articleNumber, articleTilte,
               articleContent, findMember.getMemberNumber(),
               findMember.getMemberNickName());
         return articleDAO.showSelectArticle(articleNumber);

      }
      return null;
   }

   // 글 선택시 보여여주기
   public ArticleVO selectShowArticle(int articleNumber) {
      return articleDAO.showSelectArticle(articleNumber);
   }

   // 대륙선택시 그 대츅의 글들 부여주기
   public List<ArticleVO> showAllArticleByContinent(String continent, int startRow, int blockSize) {
      return articleDAO.findAllArticleByContinent(continent, startRow, blockSize);
   }

   // 나라 선택시 그 나라의 글들 보여주기
   public List<ArticleVO> showAllArticleByCountry(String country, int startRow, int blockSize) {
      return articleDAO.findAllArticleByCountry(country, startRow, blockSize);
   }

   // 전체의 추천수가 많은 글 5개찾기
   public List<ArticleVO> showAllBestArticle() {
      return articleDAO.findBestArticle();
   }

   // 대륙의 추천수가 많은 글 5개 찾기
   public List<ArticleVO> showBestArticleByContinent(String continent) {
      return articleDAO.findBestArticleByContinent(continent);
   }

   public boolean doRecommandIncrement(int articleNumber,
         int articleRecommendCount) {
      articleDAO
            .recommendCountIncrement(articleNumber, articleRecommendCount);
      return true;
   }
   public boolean recommandAdd(String memberNickName, int articleNumber, int memberNumber){
      articleDAO.limitsRecommandadd(memberNickName, articleNumber, memberNumber);
      return true;
   }
   public ArticleRecommandVO checkRecommand(int articleNumber, String memberNickName){
      return articleDAO.checkArticleRecommand(articleNumber, memberNickName);
   }
   
   public List<ArticleVO> showAllArticleByContinent(String continent) {
      return articleDAO.findAllArticleByContinent(continent);
   }
   
   public List<ArticleVO> showAllArticleByCountry(String country) {
      return articleDAO.findAllArticleByCountry(country);
   }
}