package com.quyenlt.controllers; 

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Lấy session hiện tại
        HttpSession session = req.getSession(false); // false: không tạo session mới nếu chưa có
        
        // 2. Hủy session nếu nó tồn tại
        if (session != null) {
            session.invalidate(); // Xóa tất cả dữ liệu trong session
        }
        
        // 3. Chuyển hướng người dùng về trang chủ hoặc trang đăng nhập
        resp.sendRedirect(req.getContextPath() + "/login"); // Bạn có thể thay "/trang-chu" bằng "/login"
    }
}