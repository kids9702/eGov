package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello2")
public class MyServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		
		String cntstr = request.getParameter("cnt");
		String name = request.getParameter("name");
		if(cntstr == null || cntstr.equals("")) {
			cntstr="10";
		}
		try {
			Integer.parseInt(cntstr);
		} catch (NumberFormatException e) {
			cntstr="10";
		}
		
		int cnt = Integer.parseInt(cntstr);
		
		PrintWriter out = response.getWriter();
		for(int i = 0; i < cnt; i++) {
			out.println((i+1) + " : " + name + "님 안녕하세요<br>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		PrintWriter out = response.getWriter();
		out.println("post");
	}
	
	
}
