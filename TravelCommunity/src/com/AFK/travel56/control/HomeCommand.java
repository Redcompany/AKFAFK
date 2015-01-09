package com.AFK.travel56.control;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.FileService;
import com.AFK.travel56.service.MemberService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HomeCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		MemberService memberService = new MemberService();
		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();
		String todoCheck = request.getParameter("todo");
		HttpSession session=request.getSession(true);
		if (todoCheck != null) {

			switch (todoCheck) {
			case "회원가입":
				request.setAttribute("addMember", memberService.registerMember(
						request.getParameter("id"),
						request.getParameter("pass"),
						request.getParameter("gender"),
						request.getParameter("email"),
						request.getParameter("address"),
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				break;
			case "ID찾기":
				request.setAttribute("findID", memberService.findMemberID(
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				System.out.println(memberService.findMemberID(
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				break;
			case "Password찿기":
				request.setAttribute(
						"findPassword",
						memberService.findMemberPassword(
								request.getParameter("id"),
								request.getParameter("name"),
								request.getParameter("birth")));
				System.out.println(memberService.findMemberPassword(
						request.getParameter("id"),
						request.getParameter("name"),
						request.getParameter("birth")));
				System.out.println(request.getParameter("name"));

				break;


			case "로그인":
				request.setAttribute("memberLogin", memberService.loginMember(
						request.getParameter("id"),
						request.getParameter("pass")));
				break;
				// case "회워정보변경":
				// request.setAttribute("updateMember", memberService
				// .updateMember(request.getParameter("id"),
				// request.getParameter("pass"),
				// request.getParameter("email"),
				// request.getParameter("name"),
				// request.getParameter("phone")));
				// break;
			case "로그아웃":
				session.removeAttribute("loginsession");
				break;
			case "탈퇴":
				MemberVO memberVO=(MemberVO)session.getAttribute("loginsession"); 
				request.setAttribute("deleteMember", memberService.deleteMember(memberVO.getMemberID(), memberVO.getMemberPW()));
				session.removeAttribute("loginsession");
				break;
			}
		} else {

			System.out.println("글등록 실행?");
			String uploadPath = "C:/test";
			int size = 6 * 1024 * 1024; // 업로드 파일 최대 크기 지정
			String filename = "";
			String filename1 = "";
			try {
				MultipartRequest multi = new MultipartRequest(request,
						uploadPath, size, "UTF-8", new MyFileRenamePolicy());
				if (multi.getParameter("todo").equals("글등록"))
					;
				System.out.println("try안에 실행이 되나?");
				System.out.println(multi.getParameter("title"));
				request.setAttribute("createArticle", articleService.registerArticle(multi.getParameter("title"),
						multi.getParameter("continent"),
						multi.getParameter("country"),
						multi.getParameter("content"), "26일 쉬자"));
				// 파일 업로드. 폼에서 가져온 인자값을 얻기 위해request 객체 전달,
				// 업로드 경로, 파일 최대 크기, 한글처리, 파일 중복처리

				Enumeration files = multi.getFileNames();
				// 업로드한 파일들의 이름을 얻어옴
				String file = (String) files.nextElement();
				filename = multi.getFilesystemName(file);
				fileService.registerFile(filename, fileService.allShowFiles().size());
				String file1 = (String) files.nextElement();
				filename1 = multi.getFilesystemName(file1);
				fileService.registerFile(filename1, fileService.allShowFiles().size());
			} catch (Exception e) {
				// 예외처리
				e.printStackTrace();
			}

		}

		commandResult = new CommandResult("/WEB-INF/view/home.jsp");
		return commandResult;
	}
}
