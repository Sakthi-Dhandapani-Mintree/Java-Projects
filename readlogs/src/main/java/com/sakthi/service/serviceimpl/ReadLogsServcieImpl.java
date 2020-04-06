package com.sakthi.service.serviceimpl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.sakthi.constants.Contants;
import com.sakthi.entity.DockerServices;
import com.sakthi.service.ReadLogsServcie;

@Service
public class ReadLogsServcieImpl implements ReadLogsServcie {

	private static final Logger logger = LogManager.getLogger(ReadLogsServcieImpl.class);
	private Session session = getSSHConnection();

	@Override
	public void readLogFiles() {

	}

	@Override
	public Session getSSHConnection() {
		JSch jsch = new JSch();
		logger.info("trying to get SSH Connection ");
		Session session = null;
		String hostName = "XXXXXXXXX";
		try {
			File keyFile = new File(Contants.KEY_FILE_PATH);
			if (!keyFile.exists()) {
				String errorMsg = "Could not find SSH public key file in path: " + Contants.KEY_FILE_PATH;

				throw new JSchException(errorMsg);
			}
			jsch.addIdentity(keyFile.getAbsolutePath());

			JSch.setConfig("StrictHostKeyChecking", "no");
			if (session == null) {
				session = jsch.getSession(Contants.USER_NAME, hostName, Contants.PORT_NUMBER);
				session.connect();
				System.out.println("Connected !!!");
				logger.info("SSH Connection Successfull ");
			}

		} catch (JSchException e) {
			logger.info("trying to get SSH Connection " + e);
		}
		return session;
	}

	/**
	 * Get List of Docker Services
	 */
	@Override
	public List<DockerServices> getListDockerServices() {
		logger.info("Will collect the list of docker servcies from the instance ");
		List<DockerServices> dockerService = new ArrayList<DockerServices>();
		try {
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand("docker ps -a");
			logger.info("Executed Command is:---------->" + "docker ps -a");
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			StringBuilder stringBuilder = new StringBuilder();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					stringBuilder.append(new String(tmp, 0, i));

				}
				dockerService = convertTOEntity(stringBuilder.toString());

				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			// session.disconnect();
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dockerService;
	}

	/**
	 * Convert to ENTITY class
	 * 
	 * @param value
	 * @return
	 */
	private List<DockerServices> convertTOEntity(String value) {
		logger.info("Will convert to DockerService ");
		List<DockerServices> lisOfServices = new ArrayList<DockerServices>();
		String[] newValues = value.split("\n");
		for (int i = 1; i < newValues.length; i++) {
			String[] orginalValues = newValues[i].split(" ");
			String[] constantValues = fixConstantPositionValues(orginalValues);
			if (orginalValues != null && orginalValues.length > 0) {
				DockerServices dockerService = new DockerServices();
				dockerService.setContainerId(constantValues[0].toString());
				dockerService.setImageDetails(constantValues[1].toString());
				dockerService
						.setCommandDetails(constantValues[2].toString() + " ".concat(constantValues[3].toString()));
				dockerService.setCreatedInfo(constantValues[4].toString() + " ".concat(constantValues[5].toString())
						+ " ".concat(constantValues[6].toString()));
				if (constantValues[7].toString().equalsIgnoreCase("UP")) {
					dockerService.setStatus(constantValues[7].toString() + " ".concat(constantValues[8].toString())
							+ " ".concat(constantValues[9].toString()));
					dockerService.setPortsDetails(constantValues[10].toString());
					dockerService.setServiceNames(constantValues[11].toString());
					lisOfServices.add(dockerService);
				} else {
					dockerService.setStatus(constantValues[7].toString() + " ".concat(constantValues[8].toString())
							+ " ".concat(constantValues[9].toString() + " ".concat(
									constantValues[10].toString() + " ".concat(constantValues[11].toString()))));
					dockerService.setPortsDetails(null);
					dockerService.setServiceNames(constantValues[12].toString());
					lisOfServices.add(dockerService);
				}
			}
		}
		logger.info("List of DockerServices has been added ");
		return lisOfServices;
	}

	/**
	 * This method will help you to fix the arrayindexoutbound exception due to the
	 * result various positions
	 * 
	 * @param orginalValues
	 * @return String [] constantValues
	 */
	private String[] fixConstantPositionValues(String[] orginalValues) {
		logger.info("Invoked fixConstantPositionValues method");
		List<String> constantValues = new ArrayList<String>();
		for (int k = 0; k < orginalValues.length; k++) {
			if (orginalValues[k].length() > 0) {
				constantValues.add(orginalValues[k].toString().trim());
			}
		}
		return constantValues.stream().toArray(String[]::new);
	}

	/**
	 * For the below method is used to get actual paht of docker container for the
	 * particular sercice
	 */
	public String getLogsPath(Session session, String serviceName) {
		String logPath = new String();

		try {
			Channel channel = session.openChannel("exec");
			logger.info("docker inspect " + serviceName + " " + "| grep LogPath");
			((ChannelExec) channel).setCommand("docker inspect " + serviceName + " " + "| grep LogPath");
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			StringBuffer stringBuffer = new StringBuffer();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					stringBuffer.append(new String(tmp, 0, i));
				}
				System.out.println("------------>" + stringBuffer.toString());
				logPath = stringBuffer.toString();
				logPath = logPath.substring(20, stringBuffer.toString().length());
//				JSONObject jsonObject = new JSONObject(
//						stringBuffer.toString().substring(6, stringBuffer.toString().length() - 2));
//				System.out.println(jsonObject);
//				logPath = jsonObject.getString("LogPath");
//				System.out.println("---->" + logPath);

				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			// session.disconnect();
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logPath;

	}

	/**
	 * This method used to view the logs console now temporally only 100 lines
	 */
	@Override
	public String viewServiceLogs(Session session, String serviceName) {
		logger.info("Invoked viewServiceLogs method ");
		StringBuilder stringBuilder = new StringBuilder();
		try {
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand("docker logs " + serviceName + " " + "| tail -n 100");
			logger.info("Command Executed ------> " + "docker logs " + serviceName);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();

			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					stringBuilder.append(new String(tmp, 0, i));

				}

				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					logger.info("Exit Status :: ------> " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();

			System.out.println("DONE");
		} catch (Exception e) {
			logger.info("Exception e :: ------> " + e);
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	@Override
	public void downloadFileFromInstance(Session session, String serviceName) {

//		String path =getLogsPath(session,serviceName);
		String path = "/var/lib/docker/containers/4a35d40c0e617514222aad1651d72113528b8894188392d5b91d4d9d3a16146c/4a35d40c0e617514222aad1651d72113528b8894188392d5b91d4d9d3a16146c-json.log";
		logger.info("Invoked viewServiceLogs method ");
		StringBuilder stringBuilder = new StringBuilder();
		logger.info("Command Executed ------> " + path);
		try {
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand("sudo chmod 777 " + "/var/lib/docker/* -R");
			((ChannelExec) channel).setCommand("sudo vim " + path);

			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();

			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					stringBuilder.append(new String(tmp, 0, i));

				}

				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					logger.info("Exit Status :: ------> " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();

			System.out.println("DONE");
		} catch (Exception e) {
			logger.info("Exception e :: ------> " + e);
			e.printStackTrace();
		}

	}

}
