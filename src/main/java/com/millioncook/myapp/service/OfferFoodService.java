package com.millioncook.myapp.service;

import java.util.HashMap;

import com.millioncook.myapp.model.MstOffer;

public interface OfferFoodService {

	public HashMap<Object, Object> retrieveFoodOfferByUserIdAndDate(Long id, String strDate) throws Exception;

	public void saveFoodOfferByUserId(MstOffer offer) throws Exception;

}
