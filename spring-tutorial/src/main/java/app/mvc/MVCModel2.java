package app.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc-model2")
public class MVCModel2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		if(num == null || num.equals("")){
			num = "10";
		}
		
		String result = "";
		for(int i=0; i<Integer.parseInt(num); i++) { 
			result += "hello <br>";
		}
		request.setAttribute("result", result);
		
		String[] names = {"a","b","c","d"};
		request.setAttribute("names", names);
		
		Map<String, String> card = new HashMap<>();
		card.put("id", "111");
		card.put("name", "A");
		request.setAttribute("card", card);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(request, response);
	}
}
