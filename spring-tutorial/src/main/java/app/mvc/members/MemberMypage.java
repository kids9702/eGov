package app.mvc.members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import app.member.Member;
import app.member.service.MemberService;

@WebServlet("/mvc-model2/members/my-page")
public class MemberMypage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ApplicationContext ac = MemberConfig.getApplicationContext();
		MemberService memberService = ac.getBean(MemberService.class);
		
		try {
			Member member = memberService.findMember(Long.parseLong(id));
			request.setAttribute("member", member);
			
			String path = "/members/mypage.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
