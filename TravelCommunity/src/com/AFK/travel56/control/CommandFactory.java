package com.AFK.travel56.control;

public class CommandFactory {

	public static Command createCommand(String pathName) {
		Command target = null;

		switch (pathName) {
		case "/register":
			target = new RegisterMemberCommand();
			break;
		case "/home":
			target = new HomeCommand();
			break;
		case "/FindIDPassword":
			target = new IDPasswordFindMemberCommand();
			break;
		case "/showArticles":
			target = new ShowArticlesCommand();
			break;
		case "/loginMember":
			target = new LoginCommand();
			break;
		case "/updateMember":
			target = new UpdateMemberCommand();
			break;
		case "/readArticle":
			target = new ReadArticleCommand();
			break;
		case "/":
			target = new FrontCommand();
			break;
		case "/front":
			target = new FrontCommand();
			break;
		case "/createArticle":
			target = new CreateArticleCommand();
			break;
		case "/loginsuccess":
			target = new LoginFormCommand();
			break;
		case "/mypage":
			target = new MyPageCommand();
			break;
		case "/updateArticle":
			target = new UpdateArticleCommand();
			break;
		case "/checkID":
			target = new IDCheckCommand();
			break;
		case "/checkNickName":
			target = new NickNameCheckCommand();
			break;
		}

		return target;
	}

}
