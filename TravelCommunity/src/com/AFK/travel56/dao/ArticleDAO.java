package com.AFK.travel56.dao;

import java.util.List;

public interface ArticleDAO {

	public List<ArticleVO> findAllArticle();

	public List<ArticleVO> findBestArticle();

	public List<ArticleVO> findAllArticleByContinent(String continent);

	public List<ArticleVO> findAllArticleByCountry(String country);

	public List<ArticleVO> findBestArticleByContinent(String continent);

	public ArticleVO showSelectArticle(int articleNumber);

	public int addArticle(String title, String continent, String country,
			String content, int memberNumber, String memberNickName);

	public int updateArticle(int articleNumber, String articleTitle,
			String articleContent, int memberNumber, String memberNickName);

	public int deleteArticle(int articleNumber, String memberNickName);

	public int deleteArticle(String memberNickName);
	
	public int recommendCountIncrement(int articleNumber, int articleRecommendCount);
	
	public ArticleRecommandVO checkArticleRecommand(int articleNumber,String memberNickName);
	
	public int limitsRecommandadd(String memberNickName, int articleNumber, int memberNumber);

}
