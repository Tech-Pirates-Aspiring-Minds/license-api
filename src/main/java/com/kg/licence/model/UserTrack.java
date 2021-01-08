package com.kg.licence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_track")
public class UserTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user")
	private String user;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "logged_in")
	private Date loggedIn;

	@Column(name = "logged_out")
	private Date loggedOut;

	@Column(name = "sessionId")
	private String sessionId;

	@Column(name = "os")
	private String os;

	@Column(name = "browser")
	private String browser;

	@Column(name = "licence_id")
	private int licenceId;

	/**
	 * Mobile Device Data
	 */

	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "device_model")
	private String deviceModel;

	@Column(name = "device_type")
	private String deviceType;

	@Column(name = "device_os_version")
	private String deviceOSVersion;

	@Column(name = "app_id")
	private String appId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Date loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Date getLoggedOut() {
		return loggedOut;
	}

	public void setLoggedOut(Date loggedOut) {
		this.loggedOut = loggedOut;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public int getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceOSVersion() {
		return deviceOSVersion;
	}

	public void setDeviceOSVersion(String deviceOSVersion) {
		this.deviceOSVersion = deviceOSVersion;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}
