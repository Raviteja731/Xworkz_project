package com.xworkz.awards.dto;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.common.constraint.NotNull;

public class AwardDTO {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private int id;
	@NotNull
	@Size(min = 3, max = 15, message = "Award Name Should Be More Than 3 And less Than 15..!")
	private String awardName;
	@NotNull
	@Size(min = 3, max = 15, message = "awardMadeBy Name Should Be More Than 3 And less Than 15..!")
	private String awardMadeBy;
	@NotNull
	@Size(min = 3, max = 15, message = "ReciverName Name Should Be More Than 3 And less Than 15..!")
	private String firstReciverName;
	@NotNull
	private String recivedDate;
	@NotNull
	@Size(min = 3, max = 15, message = "AwardGivenBy Name Should Be More Than 3 And less Than 15..!")
	private String givenBy;
	@NotNull
	private boolean recived;
	@NotNull
	private boolean not_Recived;

	public AwardDTO() {
		log.info("Created AwardDTO....");
	}

	

	
	public AwardDTO(
			@Size(min = 3, max = 15, message = "Award Name Should Be More Than 3 And less Than 15..!") String awardName,
			@Size(min = 3, max = 15, message = "awardMadeBy Name Should Be More Than 3 And less Than 15..!") String awardMadeBy,
			@Size(min = 3, max = 15, message = "ReciverName Name Should Be More Than 3 And less Than 15..!") String firstReciverName,
			String recivedDate,
			@Size(min = 3, max = 15, message = "AwardGivenBy Name Should Be More Than 3 And less Than 15..!") String givenBy,
			boolean recived, boolean not_Recived) {
		super();
		this.awardName = awardName;
		this.awardMadeBy = awardMadeBy;
		this.firstReciverName = firstReciverName;
		this.recivedDate = recivedDate;
		this.givenBy = givenBy;
		this.recived = recived;
		this.not_Recived = not_Recived;
	}




	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardMadeBy() {
		return awardMadeBy;
	}

	public void setAwardMadeBy(String awardMadeBy) {
		this.awardMadeBy = awardMadeBy;
	}

	public String getFirstReciverName() {
		return firstReciverName;
	}

	public void setFirstReciverName(String firstReciverName) {
		this.firstReciverName = firstReciverName;
	}

	public String getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(String recivedDate) {
		this.recivedDate = recivedDate;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public boolean isRecived() {
		return recived;
	}

	public void setRecived(boolean recived) {
		recived = recived;
	}

	public boolean isNot_Recived() {
		return not_Recived;
	}

	public void setNot_Recived(boolean not_Recived) {
		not_Recived = not_Recived;
	}




	@Override
	public String toString() {
		return "AwardDTO [id=" + id + ", awardName=" + awardName + ", awardMadeBy=" + awardMadeBy
				+ ", firstReciverName=" + firstReciverName + ", recivedDate=" + recivedDate + ", givenBy=" + givenBy
				+ ", Recived=" + recived + ", Not_Recived=" + not_Recived + "]";
	}





	
}
