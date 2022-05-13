package app.mvc.members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc-model2/members/join-page")
public class MemberJoinPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String path = "/members/join.jsp";
		 RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		 dispatcher.forward(request, response);
	}
	
}
