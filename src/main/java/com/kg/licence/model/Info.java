package com.kg.licence.model;

public class Info {

	private String name;
	private String version;
	private String status;

	public Info() {
		this.name = "Licence API";
		this.version = "1.0.0";
		this.status = "Active";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
