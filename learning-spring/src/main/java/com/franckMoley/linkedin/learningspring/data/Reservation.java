package com.franckMoley.linkedin.learningspring.data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {

	@Id
	@Column(name="RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resId;
	
	@Column(name="ROOM_ID")
	private Double roomId;
	
	
	@Column(name="GUEST_ID")
	private Double guestId;
	
	@Column(name="RES_DATE")
	private Date resDate;

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Double getRoomId() {
		return roomId;
	}

	public void setRoomId(Double roomId) {
		this.roomId = roomId;
	}

	public Double getGuestId() {
		return guestId;
	}

	public void setGuestId(Double guestId) {
		this.guestId = guestId;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	@Override
	public String toString() {
		return "Reservations [resId=" + resId + ", roomId=" + roomId + ", guestId=" + guestId + ", resDate=" + resDate
				+ "]";
	}

	
	
	
	
	
}
