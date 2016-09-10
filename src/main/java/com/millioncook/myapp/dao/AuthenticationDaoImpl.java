package com.millioncook.myapp.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.millioncook.myapp.model.User;
import com.millioncook.myapp.model.UserAddress;
import com.millioncook.myapp.model.UserDetail;

@Repository("authenticationDao")
@Transactional
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationDaoImpl.class);

	@Override
	public User checkUserAuthentication(String user_name, String password) throws Exception {
		User user = null;
		Session session = null;
		try {
			try{
			 session = sessionFactory.getCurrentSession();
			}catch (Exception e) {
				session = sessionFactory.openSession();
			}
			String query = "from User where (MOBILE_NO =:user_name or EMAIL_ID =:user_name) and PASSWORD =:password and is_active = 1";
			user = (User) session.createQuery(query).setParameter("user_name", user_name)
					.setParameter("password", password).getSingleResult();
		} catch (NoResultException nr) {

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("message ", e.getCause().getMessage());
			throw e;
		}
		return user;
	}

	@Override
	public User checkForRegisteredUser(User user) throws Exception{
		User registeredUser = null;
		try {
			Session session = sessionFactory.openSession();
			String query = "from User where MOBILE_NO =:user_name or EMAIL_ID =:user_name";
			registeredUser = (User) session.createQuery(query).setParameter("user_name", user.getMobile_no())
					.setParameter("user_name", user.getEmail_id()).getSingleResult();
			session.close();

		} catch (NoResultException nr) {

		} catch (Exception e) {
			 logger.error("message ", e.getCause().getMessage());
			 throw e;
		}
		return registeredUser;
	}

	@Override
	public boolean registerNewUser(User newUser) throws Exception{
		boolean result = false;
		try{
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.saveOrUpdate(newUser);
			session.flush();
			tx.commit();
			session.close();
			result = true;
		}catch (NoResultException nr) {
			
		}
		catch (Exception e) {
			 logger.error("message ", e.getCause().getMessage());
			 throw e;
		}
		return result;
	}

	@Override
	public User getUserByUserId(Integer userId) throws Exception{
		User user = null;
		try {
			Session session = sessionFactory.openSession();
			String query = "from User where user_id =:user_id";
			user = (User) session.createQuery(query).setParameter("user_id", userId).getSingleResult();
			session.close();
		} catch (Exception e) {
			 logger.error("message ", e.getCause().getMessage());
			 throw e;
		}
		return user;
	}

	@Override
	public String updateNewAddress(UserAddress address) throws Exception{
		String result = "";
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.saveOrUpdate(address);
			session.flush();
			tx.commit();
			session.close();
		} catch (Exception e) {
			logger.error("message ", e.getCause().getMessage());
			throw e;
		}
		return result;
	}

	@Override
	public String updateUserDetails(UserDetail userdetail) throws Exception{
		String result = "";
		try{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(userdetail);
			session.flush();
			tx.commit();
			session.close();
		} catch (Exception e){
			logger.error("message ", e.getCause().getMessage());
			throw e;
		}
		return result;
		
	}

}
