package com.kg.licence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "licence")
@Entity
public class LicenceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "licence_key")
	private String key;

	@Column(name = "tokens")
	private long tokens;

	@Column(name = "registration")
	private int registration;

	@Column(name = "status")
	private int status;
	
	@Column(name = "expiry")
	private Date expiry;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getTokens() {
		return tokens;
	}

	public void setTokens(long tokens) {
		this.tokens = tokens;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

}
