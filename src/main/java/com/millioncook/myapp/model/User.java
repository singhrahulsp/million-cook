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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mst_User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")
	private Long user_id;

	@Column(name = "Mobile_no")
	private String mobile_no;

	@Column(name = "Email_ID")
	private String email_id;

	@Column(name = "Facebook_token")
	private String facebook_token;

	@Column(name = "Google_token")
	private String google_token;

	@Column(name = "Password")
	private String password;

	private String first_name;
	private String last_name;

	private String user_type;

	private Long created_by;

	@Column(name = "Created_Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private Date created_date;

	private Long modified_By;

	@Column(name = "Modified_Date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private Date modified_date;

	@Column(name = "Is_Active")
	private Boolean is_active;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private UserDetail user_details;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserAddress> user_address;

	public String getMobile_no() {
		return mobile_no;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFacebook_token() {
		return facebook_token;
	}

	public void setFacebook_token(String facebook_token) {
		this.facebook_token = facebook_token;
	}

	public String getGoogle_token() {
		return google_token;
	}

	public void setGoogle_token(String google_token) {
		this.google_token = google_token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Long getModified_By() {
		return modified_By;
	}

	public void setModified_By(Long modified_By) {
		this.modified_By = modified_By;
	}

	public UserDetail getUser_details() {
		return user_details;
	}

	public void setUser_details(UserDetail user_details) {
		this.user_details = user_details;
	}

	public List<UserAddress> getUser_address() {
		return user_address;
	}

	public void setUser_address(List<UserAddress> user_address) {
		this.user_address = user_address;
	}

}