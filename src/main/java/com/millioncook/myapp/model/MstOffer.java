package com.millioncook.myapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mst_offer")
public class MstOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Offer_id")
	private Long offer_id;

	private Long User_id;

	private Integer user_area;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
	private Date offer_date;
	private String offer_time;
	private Integer offer_qty;
	private Integer offer_price;
	private Character status;
	private Long created_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm" , timezone = "Asia/Kolkata")
	private Date created_date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm" , timezone = "Asia/Kolkata")
	private Date modified_date;
	private Long modified_by;
	private Boolean is_active;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="offer_id")
	private List<OfferDetail> offer_detail;

	public Long getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(Long offer_id) {
		this.offer_id = offer_id;
	}

	public Long getUser_id() {
		return User_id;
	}

	public void setUser_id(Long user_id) {
		User_id = user_id;
	}

	public Integer getUser_area() {
		return user_area;
	}

	public void setUser_area(Integer user_area) {
		this.user_area = user_area;
	}

	public Date getOffer_date() {
		return offer_date;
	}

	public void setOffer_date(Date offer_date) {
		this.offer_date = offer_date;
	}

	public String getOffer_time() {
		return offer_time;
	}

	public void setOffer_time(String offer_time) {
		this.offer_time = offer_time;
	}

	public Integer getOffer_qty() {
		return offer_qty;
	}

	public void setOffer_qty(Integer offer_qty) {
		this.offer_qty = offer_qty;
	}

	public Integer getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(Integer offer_price) {
		this.offer_price = offer_price;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public Long getModified_by() {
		return modified_by;
	}

	public void setModified_by(Long modified_by) {
		this.modified_by = modified_by;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public List<OfferDetail> getOffer_detail() {
		return offer_detail;
	}

	public void setOffer_detail(List<OfferDetail> offer_detail) {
		this.offer_detail = offer_detail;
	}

}
