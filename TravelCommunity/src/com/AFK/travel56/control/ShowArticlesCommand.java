package com.AFK.travel56.control;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.FileService;
import com.oreilly.servlet.MultipartRequest;

public class ShowArticlesCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/showArticles.jsp");
		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();
		MemberVO findMember = null;
		String uploadPath = request.getServletContext().getRealPath("/images");
//		int nowPage;
//		List<ArticleVO> findArticleSize = articleService
//				.showAllArticleByContinent(request.getParameter("continent"));
//		int rowTotalByContinent = findArticleSize.size();
//		if (request.getParameter("page") == null) {
//			nowPage = 1;
//		} else {
//			nowPage = Integer.parseInt(request.getParameter("page"));
//
//			if (nowPage < 1) {
//				nowPage = 1;
//			}
//		}
//
//		ArticlePagingVO pageNavContinent = new ArticlePagingVO(nowPage,
//				rowTotalByContinent, 5, 5, 5);
//		request.setAttribute("pageNav", pageNavContinent);

		if (request.getParameter("todo") != null) {
			if(request.getParameter("continent")!=null)	
			session.setAttribute("Articles", articleService
						.showAllArticleByContinent(
								request.getParameter("continent")));
			else{
				session.setAttribute("Articles", articleService
						.showAllArticleByCountry(
								request.getParameter("country")));
			}
		} else {
			int size = 6 * 1024 * 1024; // 업로드 파일 최대 크기 지정
			String filename = "";
			String filename1 = "";
			MultipartRequest multi = new MultipartRequest(request, uploadPath,
					size, "UTF-8", new MyFileRenamePolicy());
			System.out.println(multi.getParameter("continent"));
			try {
				findMember = (MemberVO) session.getAttribute("loginsession");
				String content = multi.getParameter("content");
				content = content.replaceAll("\r\n", "<br>"); // 줄바꿈 처리
				content = content.replaceAll("\u0020", "&nbsp;"); // 스페이스바 처리
				request.setAttribute(
						"createArticle",
						articleService.registerArticle(
								multi.getParameter("title"),
								multi.getParameter("continent"),
								multi.getParameter("country"),
								content,
								findMember.getMemberNickName()));
				// 파일 업로드. 폼에서 가져온 인자값을 얻기 위해request 객체 전달,
				// 업로드 경로, 파일 최대 크기, 한글처리, 파일 중복처리

				Enumeration files = multi.getFileNames();
				// 업로드한 파일들의 이름을 얻어옴
				String file = (String) files.nextElement();
				filename = multi.getFilesystemName(file);
				String file1 = (String) files.nextElement();
				filename1 = multi.getFilesystemName(file1);
				System.out.println(articleService.findLastArticle().getArticleNumber());
				if (filename != null) {
					request.setAttribute("fileName", fileService.registerFile(
							filename, articleService.findLastArticle().getArticleNumber()));
				} else {
					request.setAttribute("fileName", fileService.registerFile(
							"1", articleService.findLastArticle().getArticleNumber()));
					request.setAttribute("nullFiles",
							fileService.deleteFile("1"));
				}
				if (filename1 != null) {
					request.setAttribute("fileName1", fileService.registerFile(
							filename1, articleService.findLastArticle().getArticleNumber()));
				} else {
					request.setAttribute("fileName1", fileService.registerFile(
							"1", articleService.findLastArticle().getArticleNumber()));
					request.setAttribute("nullFiles",
							fileService.deleteFile("1"));
				}
				session.setAttribute("Articles", articleService
						.showAllArticleByContinent(
								multi.getParameter("continent")));
				
				request.setAttribute("continent", multi.getParameter("continent"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return commandResult;

	}
}