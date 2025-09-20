package com.quyenlt.daos;

import com.quyenlt.models.UserModel;

public interface UserDao {
	
	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean checkExistEmail(String email);
    
	boolean checkExistUsername(String username);
    
	boolean checkExistPhone(String phone);

}
