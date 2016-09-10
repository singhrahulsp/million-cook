package com.millioncook.myapp.dao;

import java.util.Date;
import java.util.List;

import com.millioncook.myapp.model.MstOffer;

public interface OfferFoodDao {

	public List<MstOffer> retrieveFoodOfferByUserIdAndDate(Long id, Date date) throws Exception;

	public void saveFoodOfferByUserId(MstOffer offer) throws Exception;

}
