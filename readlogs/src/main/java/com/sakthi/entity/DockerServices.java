package com.sakthi.entity;

public class DockerServices {
	private String containerId;
	private String imageDetails;
	private String commandDetails;
	private String createdInfo;
	private String status;
	private String portsDetails;
	private String serviceNames;

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(String imageDetails) {
		this.imageDetails = imageDetails;
	}

	public String getCommandDetails() {
		return commandDetails;
	}

	public void setCommandDetails(String commandDetails) {
		this.commandDetails = commandDetails;
	}

	public String getCreatedInfo() {
		return createdInfo;
	}

	public void setCreatedInfo(String createdInfo) {
		this.createdInfo = createdInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPortsDetails() {
		return portsDetails;
	}

	public void setPortsDetails(String portsDetails) {
		this.portsDetails = portsDetails;
	}

	public String getServiceNames() {
		return serviceNames;
	}

	public void setServiceNames(String serviceNames) {
		this.serviceNames = serviceNames;
	}

	@Override
	public String toString() {
		return "DockerServices [containerId=" + containerId + ", imageDetails=" + imageDetails + ", commandDetails="
				+ commandDetails + ", createdInfo=" + createdInfo + ", status=" + status + ", portsDetails="
				+ portsDetails + ", serviceNames=" + serviceNames + "]";
	}

}
