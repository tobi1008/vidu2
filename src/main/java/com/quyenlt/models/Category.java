package com.quyenlt.models; 

import java.io.Serializable;

public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    // Các thuộc tính tương ứng với các cột trong database
    private int cateId;
    private String cateName;
    private String icons;

    // Constructors
    public Category() {
    }

    public Category(int cateId, String cateName, String icons) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.icons = icons;
    }

    // Getters và Setters
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
}