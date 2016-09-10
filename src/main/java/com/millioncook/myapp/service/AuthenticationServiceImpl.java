package com.millioncook.myapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millioncook.myapp.controller.HelperClass;
import com.millioncook.myapp.dao.AuthenticationDao;
import com.millioncook.myapp.model.User;
import com.millioncook.myapp.model.UserAddress;
import com.millioncook.myapp.model.UserDetail;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationDao authenticationDao;

	@Override
	public User checkUserAuthentication(String user_name, String password) throws Exception {
		HelperClass helper = null;
		String encPass = "";
		User user = null;
		try {
			helper = new HelperClass();
			encPass = helper.getEncryptedPassword(password);
			user = authenticationDao.checkUserAuthentication(user_name, encPass);
		}catch (Exception e) {
			throw e;
		}
		return user;
	}

	@Override
	public String registerNewUser(User newUser) throws Exception {
		String msg = "";
		Date date = null;
		User regUser = null;
		HelperClass helper = null;
		String encPass = "";

		try {
			helper = new HelperClass();
			date = helper.getCurrentTimeStamp();
			encPass = helper.getEncryptedPassword(newUser.getPassword());
			newUser.setPassword(encPass);

			if (newUser.getUser_id() != null && newUser.getUser_id() != 0) {
				newUser.setModified_date(date);
			}
			
			if (newUser.getMobile_no() == "" || newUser.getMobile_no() == null || newUser.getMobile_no().length() != 10) {
				msg = "Please enter valid Mobile no";
				throw new Exception(msg);
			} else {
				regUser = authenticationDao.checkForRegisteredUser(newUser);
				if (regUser != null) {
					if (regUser.getMobile_no().equals(newUser.getMobile_no())) {
						msg = "Mobile no is already registered";
					} else if (regUser.getEmail_id().equals(newUser.getEmail_id())) {
						msg = "Email id is already registered";
					}
					throw new Exception(msg);
				} else {
					authenticationDao.registerNewUser(newUser);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return msg;
	}

	@Override
	public User getUserByUserId(Long userId) throws Exception {
		return authenticationDao.getUserByUserId(userId);
	}

	@Override
	public String updateNewAddress(UserAddress address) throws Exception {
		return authenticationDao.updateNewAddress(address);
	}

	@Override
	public String updateUserDetails(UserDetail userdetail) throws Exception {
		return authenticationDao.updateUserDetails(userdetail);

	}

}
