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
@Table(name = "offer_detail")
public class OfferDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Offer_detail_id")
	private Long offer_detail_id;

	private Integer category_id;
	private Integer sub_category_id;
	private String food_type;
	private String ready_time;
	private String order_time;
	private String cancel_time;

	private String delivery_option;
	private String description;
	private String status_id;
	private Long created_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm" , timezone = "Asia/Kolkata")
	private Date created_date;
	private Long modified_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm" , timezone = "Asia/Kolkata")
	private Date modified_date;
	private Boolean is_active;

	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "Offer_id")
	@JsonBackReference
	private MstOffer offer;*/

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "offer_detail_id")
	private List<OfferItemMenu> offer_item;

	public Long getOffer_detail_id() {
		return offer_detail_id;
	}

	public void setOffer_detail_id(Long offer_detail_id) {
		this.offer_detail_id = offer_detail_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getSub_category_id() {
		return sub_category_id;
	}

	public void setSub_category_id(Integer sub_category_id) {
		this.sub_category_id = sub_category_id;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public String getReady_time() {
		return ready_time;
	}

	public void setReady_time(String ready_time) {
		this.ready_time = ready_time;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public String getCancel_time() {
		return cancel_time;
	}

	public void setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
	}

	public String getDelivery_option() {
		return delivery_option;
	}

	public void setDelivery_option(String delivery_option) {
		this.delivery_option = delivery_option;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
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

	public Long getModified_by() {
		return modified_by;
	}

	public void setModified_by(Long modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	/*public MstOffer getOffer() {
		return offer;
	}

	public void setOffer(MstOffer offer) {
		this.offer = offer;
	}*/

	public List<OfferItemMenu> getOffer_item() {
		return offer_item;
	}

	public void setOffer_item(List<OfferItemMenu> offer_item) {
		this.offer_item = offer_item;
	}

}
