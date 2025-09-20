package com.quyenlt.controllers.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createsession")

public class CreateSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// khởi tạo sessions
		HttpSession s = req.getSession();
		
		//Gán dữ liệu vào Session 
		s.setAttribute("ten","Lê Tam Quyền");
		s.setAttribute("tuoi", new Integer(25));
		
		//thiết lập thời gian tồn tại session
		s.setMaxInactiveInterval(30);
		
		//hiển thị thông báo lên web
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("Xin chào bạn session đã được tạo");
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
	}
	
	
	
	
}
