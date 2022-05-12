package app.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/calculator")
public class CalculatorFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파라미터 받기
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String [] calculate = {"+", "-", "*", "/"};
		String cal = request.getParameter("cal");
		
		// 필터 판별용 변수
		boolean isValid = true;
		
		// 정수 판별
		if(!isInteger(x) || !isInteger(y)) {
			isValid = false;
		}
		// 사칙연산 판별
		if(!Arrays.asList(calculate).contains(cal)) {
			isValid = false;
		}
		
		if(isValid) {
			chain.doFilter(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("invalid value");
		}
	}

	@Override
	public void destroy() {
		
	}
	
	// 정수 판별 메서드
	public boolean isInteger(String str) {
		boolean result;
		try {
			Integer.parseInt(str);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
