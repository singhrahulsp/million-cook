package com.millioncook.myapp.controller;

import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.millioncook.myapp.model.User;
import com.millioncook.myapp.model.UserAddress;
import com.millioncook.myapp.model.UserDetail;
import com.millioncook.myapp.service.AuthenticationService;

@RestController
public class UserAuthenicateController {

	@Autowired
	AuthenticationService authenticationService;

	private static final Logger logger = LoggerFactory.getLogger(UserAuthenicateController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<Object, Object> loginAuthentication(@RequestBody User u) {
		User user = null;
		String username = "";
		HashMap<Object, Object> obj = null;
		String msg = "";
		String status = "failed";

		try {
			obj = new HashMap<Object, Object>();
			username = u.getMobile_no();
			if (username == "" || username == null) {
				username = u.getEmail_id();
			}
			user = authenticationService.checkUserAuthentication(username, u.getPassword());
			if (user != null) {
				status = "success";
				obj.put("status", "success");
				obj.put("message", "");
				obj.put("user", user);
			} else {
				msg = "Mobile no or password is incorrect";
				obj.put("message", msg);
				obj.put("status", status);
			}

		} catch (Exception e) {
			msg = e.getCause().getMessage();
			obj.put("message", msg);
			obj.put("status", status);
			logger.error("message ", e.getCause().getMessage());
		}
		return obj;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public HashMap<Object, Object> userRegistration(@RequestBody User newUser) {
		String msg = "";
		HashMap<Object, Object> hashmap = null;
		String status = "failed";

		try {
			hashmap = new HashMap<Object, Object>();
			msg = authenticationService.registerNewUser(newUser);
			if (msg == ""){
				status = "success";
			}
			hashmap.put("status", status);
			hashmap.put("message", msg);

		} catch (Exception e) {
			msg = e.getMessage();
			hashmap.put("status", status);
			hashmap.put("message", msg);
			logger.error("message ", msg);
		}
		return hashmap;
	}

	@RequestMapping(value = "/update_detail/{userId}")
	public HashMap<Object, Object> updateUserDetails(@RequestBody UserDetail userdetail,
			@PathVariable("userId") Long userId) {
		HelperClass helper = null;
		HashMap<Object, Object> hash = null;
		String result = "";
		String status = "failed";
		User user = null;
		Date date = null;
		try {
			helper = new HelperClass();
			// getting current timestamp
			date = helper.getCurrentTimeStamp();
			if (userdetail.getUser_detail_id() != null && userdetail.getUser_detail_id() != 0) {
				userdetail.setModified_date(date);
			}

			// retrieve existing user by user id
			user = authenticationService.getUserByUserId(userId);
			hash = new HashMap<Object, Object>();
			userdetail.setUser(user);

			// save or update user details
			authenticationService.updateUserDetails(userdetail);
			status = "success";
			hash.put("message", result);
			hash.put("status", status);
		} catch (Exception e) {
			result = e.getMessage();
			hash.put("status", status);
			hash.put("message", result);
			logger.error("message ", e.getCause().getMessage());
		}
		return hash;
	}

	@RequestMapping(value = "/update_address/{userId}")
	public HashMap<Object, Object> updateUserAddress(@RequestBody UserAddress userAddress, @PathVariable("userId") Long userId) {
		HelperClass helper = null;
		HashMap<Object, Object> map = null;
		User user = null;
		String msg = "";
		String status = "failed";
		Date date = null;

		try {
			helper = new HelperClass();
			// getting current timestamp
			date = helper.getCurrentTimeStamp();
			if (userAddress.getAddress_id() != null && userAddress.getAddress_id() != 0) {
				userAddress.setModified_date(date);
			}

			map = new HashMap<Object, Object>();

			// retrieve user by user id
			user = authenticationService.getUserByUserId(userId);
			userAddress.setUser(user);

			// save or update user address
			authenticationService.updateNewAddress(userAddress);
			status = "success";

			map.put("status", status);
			map.put("message", msg);

		} catch (Exception e) {
			msg = e.getMessage();
			map.put("status", status);
			map.put("message", msg);
			logger.error("message ", e.getCause().getMessage());
		}
		return map;
	}

}
