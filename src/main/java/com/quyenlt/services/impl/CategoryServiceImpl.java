package com.quyenlt.services.impl;

import java.io.File;
import java.util.List;
import com.quyenlt.daos.CategoryDAO;
import com.quyenlt.daos.impl.CategoryDAOImpl;
import com.quyenlt.models.Category;
import com.quyenlt.services.CategoryService;

@SuppressWarnings("unused")

public class CategoryServiceImpl implements CategoryService {

    // Service gọi xuống DAO
    CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category category) {
        // Lấy category cũ từ DB
        Category oldCategory = categoryDao.get(category.getCateId());

        // Cập nhật tên mới
        oldCategory.setCateName(category.getCateName());

        // Xử lý logic cho icon
        if (category.getIcons() != null && !category.getIcons().isEmpty()) {
            // Phần này trong slide có logic xóa file ảnh cũ. 
            // Đây là nghiệp vụ nâng cao, bạn có thể thêm vào sau khi đã có chức năng upload file.
            // Ví dụ:
            // String oldIcon = oldCategory.getIcons();
            // if (oldIcon != null) {
            //     final String dir = "E:\\upload"; // Cấu hình đường dẫn upload của bạn
            //     File file = new File(dir + "/category/" + oldIcon);
            //     if (file.exists()) {
            //         file.delete();
            //     }
            // }
            oldCategory.setIcons(category.getIcons());
        }
        
        // Gọi DAO để cập nhật category đã được thay đổi vào DB
        categoryDao.edit(oldCategory);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}