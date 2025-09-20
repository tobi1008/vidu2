package com.quyenlt.services;

import com.quyenlt.models.UserModel;

public interface UserService {
	
	UserModel login(String username, String password);
	UserModel findByUserName(String username);
	
	// --- Bổ sung các phương thức mới cho chức năng đăng ký ---
	void insert(UserModel user); // Dùng UserModel cho nhất quán với project của bạn

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);

}
