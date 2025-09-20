package com.quyenlt.controllers.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showsession")
public class ShowSession extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// hiển thị session lên web
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String ten ="";
		
		// khởi tạo session
		HttpSession s = req.getSession();
		
		// truy xuất dữ liệu từ session
		Object obj= s.getAttribute("ten");
		
		//kiểm tra đối tượng Object có null không
		if(obj != null) {
			// ép kiểu về string
			ten = String.valueOf(obj);
		}else {
			// nếu null thì chuyển về trang tạo session
			resp.sendRedirect("/createsession");
		}
		// ép kiểu
		int tuoi = (Integer)s.getAttribute("tuoi");
		
		// hiển thị session lên web
		out.println("Xin chào bạn:" + ten + " tuổi: " + tuoi);
		out.close();
		
	}

}
