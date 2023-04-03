package com.xworkz.awards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;


@Entity
@Table(name = "award")
@NamedQuery(name = "findByAwardName", query = "select ent from AwardEntity ent where ent.awardName=:by")
public class AwardEntity {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "AwardName")
	private String awardName;
	@Column(name = "FirstRecived")
	private String firstReciverName;
	@Column(name = "awardMadeBy")
	private String awardMadeBy;
	@Column(name = "GivenBy")
	private String givenBy;
	@Column(name = "RecivedDate")
	private String recivedDate;
	@Column(name = "Recived")
	private boolean recived;
	@Column(name = "Not_Recived")
	private boolean not_Recived;

	public AwardEntity() {
		log.info("created AwardEntity....");
	}

	public AwardEntity(int id, String awardName, String firstReciverName, String awardMadeBy, String givenBy,
			String recivedDate, boolean recived, boolean not_Recived) {
		super();
		this.id = id;
		this.awardName = awardName;
		this.firstReciverName = firstReciverName;
		this.awardMadeBy = awardMadeBy;
		this.givenBy = givenBy;
		this.recivedDate = recivedDate;
		this.recived = recived;
		this.not_Recived = not_Recived;
	}

	@Override
	public String toString() {
		return "AwardEntity [id=" + id + ", awardName=" + awardName + ", firstReciverName=" + firstReciverName
				+ ", awardMadeBy=" + awardMadeBy + ", givenBy=" + givenBy + ", recivedDate=" + recivedDate
				+ ", recived=" + recived + ", not_Recived=" + not_Recived + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getFirstReciverName() {
		return firstReciverName;
	}

	public void setFirstReciverName(String firstReciverName) {
		this.firstReciverName = firstReciverName;
	}

	public String getAwardMadeBy() {
		return awardMadeBy;
	}

	public void setAwardMadeBy(String awardMadeBy) {
		this.awardMadeBy = awardMadeBy;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public String getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(String recivedDate) {
		this.recivedDate = recivedDate;
	}

	public boolean isRecived() {
		return recived;
	}

	public void setRecived(boolean recived) {
		this.recived = recived;
	}

	public boolean isNot_Recived() {
		return not_Recived;
	}

	public void setNot_Recived(boolean not_Recived) {
		this.not_Recived = not_Recived;
	}

	
	
}
