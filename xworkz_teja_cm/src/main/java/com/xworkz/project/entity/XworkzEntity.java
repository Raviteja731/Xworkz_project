package com.xworkz.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xworkz.project.dto.AuditDto;


@Entity
@Table(name = "signup_table")
@NamedQuery(name="find", query = "select ant from XworkzEntity ant")
public class XworkzEntity extends AuditDto {

	
	@Id
	@Column(name="signUpId")
	private int id;
	@Column(name="userId")
	private String userId;
	@Column(name="email")
	private String email;
	@Column(name="mobileNo")
	private long mobileNo;
	@Column(name="password")
	private String password;
	@Column(name = "aggried")
	private boolean aggried;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "createdDateTime")
	private LocalDateTime createdDateTime;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "UpdatedDateTime")
	private LocalDateTime UpdatedDateTime;
	
	public XworkzEntity(int id, String userId, String email, long mobileNo, String password,
			boolean aggried, String createdBy, LocalDateTime createdDateTime, String updatedBy,
			LocalDateTime updatedDateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.aggried = aggried;
		this.createdBy = createdBy;
		this.createdDateTime = createdDateTime;
		this.updatedBy = updatedBy;
		this.UpdatedDateTime = updatedDateTime;
	}


	@Override
	public String toString() {
		return "XworkzEntity [id=" + id + ", userId=" + userId + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + ", aggried=" + aggried
				+ ", createdBy=" + createdBy + ", createdDateTime=" + createdDateTime + ", updatedBy=" + updatedBy
				+ ", UpdatedDateTime=" + UpdatedDateTime + "]";
	}


	public XworkzEntity() {
		System.out.println("Created XworkzEntity in Entity..."+getClass().getSimpleName());
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAggried() {
		return aggried;
	}

	public void setAggried(boolean aggried) {
		this.aggried = aggried;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public LocalDateTime getUpdatedDateTime() {
		return UpdatedDateTime;
	}


	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		UpdatedDateTime = updatedDateTime;
	}
	
	
}
