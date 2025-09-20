package com.quyenlt.controllers;

import java.io.IOException;

import com.quyenlt.services.UserService;
import com.quyenlt.services.impl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    // Khởi tạo UserService để gọi các hàm xử lý logic
    private UserService userService = new UserServiceImpl();

    /**
     * Hiển thị trang register.jsp
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Kiểm tra xem người dùng đã đăng nhập chưa, nếu rồi thì chuyển về trang admin
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin/home");
            return;
        }
        
        // Nếu chưa đăng nhập, hiển thị trang đăng ký
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/register.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Xử lý dữ liệu từ form đăng ký
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set encoding UTF-8 cho request để đọc đúng tiếng Việt
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 1. Lấy dữ liệu từ form
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        
        // 2. Kiểm tra dữ liệu (Validation)
        // Kiểm tra email đã tồn tại chưa
        if (userService.checkExistEmail(email)) {
            req.setAttribute("alert", "Email đã tồn tại!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra username đã tồn tại chưa
        if (userService.checkExistUsername(username)) {
            req.setAttribute("alert", "Tài khoản đã tồn tại!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        
        // 3. Gọi service để thực hiện đăng ký
        boolean isSuccess = userService.register(email, password, username, fullname, phone);
        
        if (isSuccess) {
            // Nếu đăng ký thành công, chuyển hướng về trang đăng nhập
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            // Nếu có lỗi hệ thống, báo lỗi lại trang đăng ký
            req.setAttribute("alert", "System error!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}