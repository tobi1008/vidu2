package com.quyenlt.controllers.admin;

import java.io.File;
import java.io.IOException;

import com.quyenlt.models.Category;
import com.quyenlt.services.CategoryService;
import com.quyenlt.services.impl.CategoryServiceImpl;
import com.quyenlt.utils.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = "/admin/category/add")
@MultipartConfig // 1. Khai báo đây là Servlet xử lý multipart/form-data
public class CategoryAddController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            // 2. Lấy giá trị từ các trường input thông thường
            String cateName = req.getParameter("cate_name");
            
            // 3. Lấy file từ input type="file"
            Part filePart = req.getPart("icons");
            
            Category category = new Category();
            category.setCateName(cateName);

            // Xử lý file nếu có
            if (filePart != null && filePart.getSize() > 0) {
                // Tạo tên file mới độc nhất để tránh trùng lặp
                String originalFileName = filePart.getSubmittedFileName();
                String newFileName = System.currentTimeMillis() + "_" + originalFileName;

                // Ghi file vào thư mục đã cấu hình trong Constant.DIR
                String uploadPath = Constant.DIR;
                filePart.write(uploadPath + File.separator + newFileName);
                
                category.setIcons(newFileName);
            }
            
            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}