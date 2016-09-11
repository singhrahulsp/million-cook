package com.millioncook.myapp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millioncook.myapp.controller.HelperClass;
import com.millioncook.myapp.dao.OfferFoodDao;
import com.millioncook.myapp.model.MstOffer;
import com.millioncook.myapp.model.OfferDetail;

@Service
public class OfferFoodServiceImpl implements OfferFoodService {
	
	@Autowired OfferFoodDao offerFoodDao;

	@Override
	public HashMap<Object, Object> retrieveFoodOfferByUserIdAndDate(Long id, String strDate) throws Exception{
		
		HelperClass helper = null;
		Date date = null;
		List<MstOffer> offer = null;
		HashMap<Object, Object> map = null;
		String status = "failed";
		try{
			map =  new HashMap<Object, Object>();
			helper = new HelperClass();
			date = helper.getFormattedDate(strDate);
			offer = offerFoodDao.retrieveFoodOfferByUserIdAndDate(id, date);
			if (offer != null && offer.size() != 0){
				status = "success";
			}else {
				throw new Exception("No Offer found");
			}
			map.put("offer", offer);
			map.put("status", status);
		}catch (Exception e) {
			map.put("status", status);
			throw e;
		}
		return map;
	}

	@Override
	public void saveFoodOfferByUserId(MstOffer offer) throws Exception{
		HelperClass helper = null;
		Date date = null;
		try {
			helper = new HelperClass();
			date = helper.getCurrentTimeStamp();
			if (offer.getOffer_id() != null && offer.getOffer_id() != 0){
				offer.setModified_date(date);
			}
			if (offer.getOffer_detail() != null){
				for (OfferDetail detail : offer.getOffer_detail()){
					if (detail.getOffer_detail_id() != null && detail.getOffer_detail_id() != 0){
						detail.setModified_date(date);
					}
				}
			}
			offerFoodDao.saveFoodOfferByUserId(offer);
		} catch (Exception e) {
			throw e;
		}
	}

}
