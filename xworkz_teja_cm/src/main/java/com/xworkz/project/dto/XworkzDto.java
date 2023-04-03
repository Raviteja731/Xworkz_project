package com.xworkz.project.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class XworkzDto extends AuditDto {

	
//	private int id;
	@NotNull
	@Size(min = 3, max = 15, message = "userId Should Be More Than 3 And less Than 15..!")
	private String userId;
	@NotNull
	@Size(min = 3, max = 15, message = "email Should Be More Than 3 And less Than 15..!")
	private String email;
	@NotNull
	private long mobileNo;
	@NotNull
	@Size(min = 3, max = 15, message = "password Should Be More Than 3 And less Than 15..!")
	private String password;
	@NotNull
	@Size(min = 3, max = 15, message = "confirmPassword Should Be More Than 3 And less Than 15..!")
	private String confirmPassword;
	private boolean aggried;
	
	public XworkzDto() {
		System.out.println("Created XworkzDto in dto..."+getClass().getSimpleName());
	}	

	public XworkzDto(String userId, String email, long mobileNo, String password,
			String confirmPassword, boolean aggried) {
		super();
		this.userId = userId;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.aggried = aggried;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	@Override
	public String toString() {
		return "XworkzDto [ userId=" + userId + ", email=" + email + ", mobileNo="
				+ mobileNo + ", password=" + password + ", confirmPassword=" + confirmPassword + ", aggried=" + aggried
				+ "]";
	}

	public boolean isAggried() {
		return aggried;
	}

	public void setAggried(boolean aggried) {
		this.aggried = aggried;
	}
	
	
}
