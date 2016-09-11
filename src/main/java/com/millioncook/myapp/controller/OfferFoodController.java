package com.millioncook.myapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.millioncook.myapp.model.MstOffer;
import com.millioncook.myapp.service.OfferFoodService;

@RestController
public class OfferFoodController {
	
	@Autowired OfferFoodService offerFoodService;
	
	@RequestMapping(value = "/retrieve_offer/{id}/{date}")
	public HashMap<Object, Object> retriveOfferByUserId(@PathVariable("id") Long id, @PathVariable("date") String date) {
		HashMap<Object, Object> object = null;
		String msg = "";
		String status = "failed";
		try {
			object = offerFoodService.retrieveFoodOfferByUserIdAndDate(id, date);

		} catch (Exception e) {
			object = new HashMap<Object, Object>();
			msg = e.getMessage();
			object.put("message", msg);
			object.put("status", status);
		}
		return object;
	}
	
	@RequestMapping(value="/save_food_offer", method= RequestMethod.POST)
	public HashMap<Object, Object>saveFoodOfferByUserId(@RequestBody MstOffer offer){
		HashMap<Object, Object> map = null;
		String msg = "";
		String status = "failed";
		try {
			map = new HashMap<Object, Object>();
			offerFoodService.saveFoodOfferByUserId(offer);
			status = "success";
			map.put("status", status);
			map.put("message", msg);
		} catch (Exception e) {
			msg = e.getMessage();
			map.put("message", msg);
			map.put("status", status);
		}
		return map;
	}

}
