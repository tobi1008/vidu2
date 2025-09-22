<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Danh mục</title>
    </head>
<body>
    <div class="container">
        <h2>Quản lý Danh mục</h2>
        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary">Thêm mới</a>
        <hr>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Hình ảnh</th>
                    <th>Tên danh mục</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cateList}" var="cate" varStatus="STT">
                    <tr>
                        <td>${STT.index + 1}</td>
                        <td>
                            <c:url value="/image?fname=${cate.icons}" var="imgUrl"/>
                            <img height="150" width="200" src="${imgUrl}" />
                        </td>
                        <td>${cate.cateName}</td>
                        <td class="center">
                            <a href="<c:url value='/admin/category/edit?id=${cate.cateId}'/>">Sửa</a> | 
                            <a href="<c:url value='/admin/category/delete?id=${cate.cateId}'/>" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>