package app.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/calculator")
public class CharacterEncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		try {
			Integer.parseInt(request.getParameter("x"));
			Integer.parseInt(request.getParameter("y"));
			if(request.getParameter("cal").contentEquals("+") || request.getParameter("cal").equals("-") || request.getParameter("cal").equals("*") || request.getParameter("cal").equals("/")) {
				
			}else {
				out.println("invalid value");
			}
		} catch (Exception e) {
			out.println("invalid value");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
