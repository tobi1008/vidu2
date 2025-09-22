<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Danh mục</title>
</head>
<body>
    <div class="container">
        <h2>Thêm Danh mục mới</h2>
        <hr>
        <%-- Lưu ý action và enctype --%>
        <form role="form" action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>Tên danh mục:</label>
                <input class="form-control" placeholder="Please enter category Name" name="cate_name" />
            </div>
            <div class="form-group">
                <label>Ảnh đại diện:</label>
                <input type="file" name="icons" />
            </div>
            <button type="submit" class="btn btn-default">Thêm</button>
            <button type="reset" class="btn btn-primary">Hủy</button>
        </form>
    </div>
</body>
</html>