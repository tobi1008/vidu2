package com.quyenlt.controllers.cookies;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/login-cookie"})
public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if(user.equals("quyen") && pass.equals("123"))
		{
		// khởi tạo cookie
		Cookie cookie = new Cookie("username",user);
		
		// thiết lập thời gian tồn tại 30s của cookie
		cookie.setMaxAge(30);
		
		// thêm cookie vào response
		resp.addCookie(cookie);
		
		// chuyển sang trang HelloServlet.java
		resp.sendRedirect("/vidu2/hello");
		}else {
			
		// Chuyển sang trang LoginServlet
		resp.sendRedirect("/vidu2/login");
		}
	}
	
}
