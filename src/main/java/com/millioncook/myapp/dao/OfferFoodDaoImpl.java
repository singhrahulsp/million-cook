package com.millioncook.myapp.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.millioncook.myapp.model.MstOffer;

@Transactional
@Repository
public class OfferFoodDaoImpl implements OfferFoodDao{
	
	@Autowired SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<MstOffer> retrieveFoodOfferByUserIdAndDate(Long id, Date date) throws Exception {
		List<MstOffer> offer = null;
		Session session = null;
		try{
			 session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			String qry = "from MstOffer where user_id=:userId and offer_date =:date";
			offer = (List<MstOffer>) session.createQuery(qry).setParameter("userId", id).setParameter("date", date).getResultList();
			tx.commit();
		}catch (Exception e) {
			throw e;
		}
		return offer;
	}

	@Override
	public void saveFoodOfferByUserId(MstOffer offer) throws Exception{
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(offer);
			session.flush();
			tx.commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}

}
