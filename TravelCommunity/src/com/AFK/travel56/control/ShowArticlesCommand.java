package com.AFK.travel56.control;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticlePagingVO;
import com.AFK.travel56.dao.ArticleVO;
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

		// 객체를 생성한다 (현재페이지, 전체글수, 페이지당표시할 글의수, 한번에 표시할 페이징블록수, 한 페이지에 나오는 게시글 수)
		int nowPage = 1;
		List<ArticleVO> findArticleSize = articleService
				.showAllArticleByContinent(request.getParameter("continent"));

		if (request.getParameter("todo") != null) {
			if (request.getParameter("todo").equals("articlePage")) {

				if (request.getParameter("page") == null) {
					nowPage = 1;
				} else {
					nowPage = Integer.parseInt(request.getParameter("page"));

					if (nowPage < 1) {
						nowPage = 1;
					}
				}
				int rowTotalByContinent = findArticleSize.size();
				ArticlePagingVO pageNavContinent = new ArticlePagingVO(nowPage,
						rowTotalByContinent, 5, 5, 5);

//				request.setAttribute("pageIsPrev",
//						pageNavContinent.isPrevPage()); // 이전페이지
//				request.setAttribute("pageIsNext",
//						pageNavContinent.isNextPage()); // 다음페이지
//				request.setAttribute("pageStart",
//						pageNavContinent.getStartPage());// 시작페이지
//				request.setAttribute("pageEnd", pageNavContinent.getEndPage()); // 종료페이지
				request.setAttribute("pageNav", pageNavContinent);
			} else if (request.getParameter("continent") != null) {
				session.setAttribute("Articles", articleService
						.showAllArticleByContinent(request
								.getParameter("continent")));
			} else if (request.getParameter("country") != null) {
				session.setAttribute("Articles", articleService
						.showAllArticleByCountry(request
								.getParameter("country")));
			}

		} else {
			/*
			 * request.getSession().getServletContext() .getRealPath("/images");
			 */
			int size = 6 * 1024 * 1024; // 업로드 파일 최대 크기 지정
			String filename = "";
			String filename1 = "";
			MultipartRequest multi = new MultipartRequest(request, uploadPath,
					size, "UTF-8", new MyFileRenamePolicy());

			try {
				findMember = (MemberVO) session.getAttribute("loginsession");
				request.setAttribute(
						"createArticle",
						articleService.registerArticle(
								multi.getParameter("title"),
								multi.getParameter("continent"),
								multi.getParameter("country"),
								multi.getParameter("content"),
								findMember.getMemberNickName()));
				// 파일 업로드. 폼에서 가져온 인자값을 얻기 위해request 객체 전달,
				// 업로드 경로, 파일 최대 크기, 한글처리, 파일 중복처리

				Enumeration files = multi.getFileNames();
				// 업로드한 파일들의 이름을 얻어옴
				String file = (String) files.nextElement();
				filename = multi.getFilesystemName(file);
				String file1 = (String) files.nextElement();
				filename1 = multi.getFilesystemName(file1);
				if (filename != null) {
					request.setAttribute("fileName", fileService.registerFile(
							filename, articleService.findAllArticles().size()));
				} else {
					request.setAttribute("fileName", fileService.registerFile(
							"1", articleService.findAllArticles().size()));
					request.setAttribute("nullFiles",
							fileService.deleteFile("1"));
				}
				if (filename1 != null) {
					request.setAttribute("fileName1", fileService.registerFile(
							filename1, articleService.findAllArticles().size()));
				} else {
					request.setAttribute("fileName1", fileService.registerFile(
							"1", articleService.findAllArticles().size()));
					request.setAttribute("nullFiles",
							fileService.deleteFile("1"));
				}
				session.setAttribute("Articles", articleService
						.showAllArticleByContinent(
								multi.getParameter("continent")));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return commandResult;

	}
}
