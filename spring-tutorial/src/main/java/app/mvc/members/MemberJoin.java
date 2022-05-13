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

@WebServlet("/mvc-model2/members/join")
public class MemberJoin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		ApplicationContext ac = MemberConfig.getApplicationContext();
		MemberService memberService = ac.getBean(MemberService.class);
		
		Member member = new Member();
		member.setId(Long.parseLong(id));
		member.setName(name);
		
		try {
			memberService.join(member);
			
			response.sendRedirect("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = "/members/join.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
}
