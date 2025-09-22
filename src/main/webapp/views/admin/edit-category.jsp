<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Danh mục</title>
</head>
<body>
    <div class="container">
        <h2>Chỉnh sửa Danh mục</h2>
        <hr>
        <form action="${pageContext.request.contextPath}/admin/category/edit" method="post" enctype="multipart/form-data">
            
            <%-- Input ẩn để gửi ID của category cần sửa --%>
            <input type="hidden" name="cate_id" value="${category.cateId}" />
            
            <div class="form-group">
                <label>Tên danh mục:</label>
                <input class="form-control" name="cate_name" value="${category.cateName}" />
            </div>
            
            <div class="form-group">
                <label>Ảnh đại diện hiện tại:</label>
                <div>
                    <c:url value="/image?fname=${category.icons}" var="imgUrl"/>
                    <img class="img-responsive" width="100px" src="${imgUrl}" alt="">
                </div>
            </div>

            <div class="form-group">
                <label>Tải lên ảnh mới (bỏ trống nếu không muốn thay đổi):</label>
                <input type="file" name="icons" />
            </div>
            
            <button type="submit" class="btn btn-default">Lưu thay đổi</button>
            <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-primary">Hủy</a>
        </form>
    </div>
</body>
</html>