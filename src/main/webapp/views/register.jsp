<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    </head>
<body>

<div class="container">
    <form action="register" method="post">
        <h2>Tạo tài khoản mới</h2>

        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>

        <div class="form-group">
            <label>Tên đăng nhập</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" class="form-control" name="username" placeholder="Tên đăng nhập">
            </div>
        </div>
        
        <div class="form-group">
            <label>Họ tên</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-font"></i></span>
                <input type="text" class="form-control" name="fullname" placeholder="Họ và tên">
            </div>
        </div>

        <div class="form-group">
            <label>Email</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                <input type="email" class="form-control" name="email" placeholder="Nhập Email">
            </div>
        </div>

        <div class="form-group">
            <label>Mật khẩu</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="password" placeholder="Mật khẩu">
            </div>
        </div>

        <div class="form-group">
            <label>Nhập lại mật khẩu</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <input type="password" class="form-control" name="repassword" placeholder="Nhập lại mật khẩu">
            </div>
        </div>
        
        <button type="submit" class="btn btn-primary">Tạo tài khoản</button>
        <p>Nếu bạn đã có tài khoản? <a href="login">Đăng nhập</a></p>
    </form>
</div>

</body>
</html>