package com.AFK.travel56.control;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.CommentService;
import com.AFK.travel56.service.FileService;
import com.oreilly.servlet.MultipartRequest;

public class ReadArticleCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/readArticle.jsp");
		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();
		CommentService commentService = new CommentService();
		
		HttpSession session = request.getSession(true);

		request.setAttribute("showComments", commentService
				.showAllCommentByArticle(Integer.parseInt(request
						.getParameter("idx"))));
		
		MemberVO commentMember = (MemberVO) session.getAttribute("loginsession");
				System.out.println("comment??  "+request.getParameter("inComment"));
		if(request.getParameter("inComment")!=null){
		session.setAttribute("registerComment", commentService
				.registerComment(request.getParameter("inComment"),
						commentMember.getMemberNumber(),
						commentMember.getMemberNickName(),
						Integer.parseInt(request.getParameter("idx"))));
		}
		
//		List<ArticleVO> returnArticle = (List<ArticleVO>) request.getAttribute("Articles");
//		for(int i=0; i<returnArticle.size(); ++i){
//			ArticleVO returntest = returnArticle.get(i);
//			
//		}
		// 두혁이
		System.out.println(request.getParameter("todo"));

		if (request.getParameter("idx") != null) {
			session.setAttribute("Article", articleService
					.selectShowArticle(Integer.parseInt(request
							.getParameter("idx"))));

		} else if (request.getParameter("todo").equals("글수정")) {
			System.out.println("나오냐?");
			ArticleVO findArticle = (ArticleVO) session.getAttribute("Article");
			MemberVO findMember = (MemberVO) session
					.getAttribute("loginsession");
			session.setAttribute("Article", articleService.updateArticle(
					findArticle.getArticleNumber(),
					request.getParameter("title"),
					request.getParameter("content"),
					findMember.getMemberNickName()));
		} else {
			String uploadPath = "C:/test";
			int size = 6 * 1024 * 1024; // 업로드 파일 최대 크기 지정
			String filename = "";
			String filename1 = "";
			try {
				MultipartRequest multi = new MultipartRequest(request,
						uploadPath, size, "UTF-8", new MyFileRenamePolicy());
				MemberVO findMember = (MemberVO) session
						.getAttribute("loginsession");
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
				if (file != null) {
					fileService.registerFile(filename, articleService
							.findAllArticles().size());
				} else {
					fileService.registerFile("1", articleService
							.findAllArticles().size());
					fileService.deleteFile("1");
				}
				if (file1 != null) {
					fileService.registerFile(filename1, articleService
							.findAllArticles().size());
				} else {
					fileService.registerFile("1", articleService
							.findAllArticles().size());
					fileService.deleteFile("1");
				}
				session.setAttribute("Article", articleService
						.selectShowArticle(articleService.findAllArticles()
								.size()));

			} catch (Exception e) {
				// 예외처리
				e.printStackTrace();
			}

		}
		return commandResult;
	}
}