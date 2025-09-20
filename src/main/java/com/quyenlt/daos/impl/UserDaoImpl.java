package com.quyenlt.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.quyenlt.configs.DBConnect;
import com.quyenlt.daos.UserDao;
import com.quyenlt.models.UserModel;

public class UserDaoImpl implements UserDao {

	@Override
	public UserModel findByUserName(String username) {
		// Giữ nguyên tên bảng 'users' (số nhiều) như code gốc của bạn
		String sql = "SELECT * FROM `users` WHERE username = ?";
		try (Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					UserModel user = new UserModel();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setFullname(rs.getString("fullname"));
					user.setPassword(rs.getString("password"));
					user.setAvatar(rs.getString("avatar"));
					// Sửa lại tên hàm cho đúng chuẩn camelCase
					user.setRoleid(rs.getInt("roleId")); 
					user.setPhone(rs.getString("phone"));
					user.setCreatedDate(rs.getDate("createdDate"));
					return user;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO `users`(email, username, fullname, password, avatar, roleId, phone, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getAvatar());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, new java.sql.Date(user.getCreatedDate().getTime()));
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		String sql = "SELECT * FROM `users` WHERE email = ?";
		try (Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "SELECT * FROM `users` WHERE username = ?";
		try (Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		String sql = "SELECT * FROM `users` WHERE phone = ?";
		try (Connection conn = DBConnect.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, phone);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}