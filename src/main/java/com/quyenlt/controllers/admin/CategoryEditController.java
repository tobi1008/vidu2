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

@WebServlet(urlPatterns = "/admin/category/edit")
@MultipartConfig // Thêm annotation này
public class CategoryEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = cateService.get(Integer.parseInt(id));
        req.setAttribute("category", category);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            // Lấy dữ liệu từ các trường input
            int cateId = Integer.parseInt(req.getParameter("cate_id"));
            String cateName = req.getParameter("cate_name");
            
            // Lấy file upload
            Part filePart = req.getPart("icons");

            Category category = new Category();
            category.setCateId(cateId);
            category.setCateName(cateName);

            // Xử lý file nếu người dùng có upload file mới
            if (filePart != null && filePart.getSize() > 0) {
                String originalFileName = filePart.getSubmittedFileName();
                String newFileName = System.currentTimeMillis() + "_" + originalFileName;
                String uploadPath = Constant.DIR;
                filePart.write(uploadPath + File.separator + newFileName);
                category.setIcons(newFileName);
            }
            
            // Gọi service để cập nhật
            cateService.edit(category);
            
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");

        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần
        }
    }
}