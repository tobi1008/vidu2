package com.quyenlt.daos; 

import java.util.List;
import com.quyenlt.models.Category; 

public interface CategoryDAO {

    void insert(Category category);

    void edit(Category category);

    void delete(int id);

    Category get(int id);

    Category get(String name);

    List<Category> getAll();

    List<Category> search(String keyword);
}