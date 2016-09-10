package com.millioncook.myapp.dao;

import com.millioncook.myapp.model.User;
import com.millioncook.myapp.model.UserAddress;
import com.millioncook.myapp.model.UserDetail;

public interface AuthenticationDao {

	public User checkUserAuthentication(String user_name, String password) throws Exception;

	public User checkForRegisteredUser(User user) throws Exception;

	public boolean registerNewUser(User newUser) throws Exception;

	public User getUserByUserId(Long userId) throws Exception;

	public String updateNewAddress(UserAddress address) throws Exception;

	public String updateUserDetails(UserDetail userdetail) throws Exception;

}
