package com.quyenlt.services.impl;

import java.sql.Date;

import com.quyenlt.daos.UserDao;
import com.quyenlt.daos.impl.UserDaoImpl;
import com.quyenlt.models.UserModel;
import com.quyenlt.services.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl(); // gọi tất cả các phương thức của tầng DAO

    @Override
    public UserModel findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserName(username);

        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

	// --- Triển khai logic cho các phương thức đăng ký ---
	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		// 1. Kiểm tra username đã tồn tại chưa
		if (userDao.checkExistUsername(username)) {
			return false; // Trả về false nếu đã tồn tại
		}

		// 2. Nếu chưa tồn tại, tạo một đối tượng UserModel mới
		UserModel newUser = new UserModel();
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setFullname(fullname);
		newUser.setPassword(password); // Lưu ý: Mật khẩu nên được mã hóa trong ứng dụng thực tế
		newUser.setPhone(phone);
		newUser.setRoleid(5); // Gán Role ID mặc định là 5 (theo slide)
		newUser.setCreatedDate(new Date(System.currentTimeMillis())); // Lấy ngày giờ hiện tại

		// 3. Gọi DAO để chèn người dùng mới vào database
		userDao.insert(newUser);

		return true; // Trả về true nếu thành công
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
}