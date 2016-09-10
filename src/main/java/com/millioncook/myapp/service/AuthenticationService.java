package com.millioncook.myapp.service;

import com.millioncook.myapp.model.User;
import com.millioncook.myapp.model.UserAddress;
import com.millioncook.myapp.model.UserDetail;

public interface AuthenticationService {

	public User checkUserAuthentication(String user_name, String password) throws Exception;

	public String registerNewUser(User newUser) throws Exception;

	public User getUserByUserId(Integer userId) throws Exception;

	public String updateNewAddress(UserAddress address) throws Exception;

	public String updateUserDetails(UserDetail userdetail) throws Exception;

}
