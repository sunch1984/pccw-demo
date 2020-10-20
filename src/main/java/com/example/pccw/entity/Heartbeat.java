package com.example.pccw.entity;


public class Heartbeat {

	// version:"x.y.z",
	private String version;
	private String releasedAt;

	public Heartbeat() {

	}

	public Heartbeat(String version, String releasedAt) {
		this.version = version;
		this.releasedAt = releasedAt;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getReleasedAt() {
		return releasedAt;
	}

	public void setReleasedAt(String releasedAt) {
		this.releasedAt = releasedAt;
	}

}
