package com.sakthi.service;

import java.util.List;

import com.jcraft.jsch.Session;
import com.sakthi.entity.DockerServices;

public interface ReadLogsServcie {
	public void readLogFiles();
	public Session getSSHConnection();
	List<DockerServices> getListDockerServices();
	String viewServiceLogs(Session session,String serviceName);
	public void downloadFileFromInstance(Session session, String serviceName);
}
