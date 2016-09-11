package com.millioncook.myapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer_item_menu")
public class OfferItemMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long item_id;
	private String item_desc;
	private boolean is_active;

	/*@ManyToOne
	@JoinColumn(name = "offer_detail_id")
	@JsonBackReference
	private OfferDetail offer_detail;*/

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	/*public OfferDetail getOffer_detail() {
		return offer_detail;
	}

	public void setOffer_detail(OfferDetail offer_detail) {
		this.offer_detail = offer_detail;
	}*/

}
