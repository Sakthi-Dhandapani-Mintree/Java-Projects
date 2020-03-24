package com.juteproduct.service.serviceimpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.juteproduct.response.DocumentResponseFromS3;
import com.juteproduct.service.IDocumentAwsService;

@Service
public class DocumentAwsServiceImpl implements IDocumentAwsService {
	private static final Logger logger = LogManager.getLogger(DocumentAwsServiceImpl.class);

	@Autowired
	private Environment env;

	private AmazonS3 amazonS3Client;
	private String bucketName;
	public static final String BUCKET_ENV_STR = "amazon.s3.bucketName";

	@PostConstruct
	private void initializeAmazon() {
		this.amazonS3Client = AmazonS3ClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
						env.getProperty("amazon.s3.endpointUrl"), env.getProperty("amazon.region")))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
						env.getProperty("amazon.access-key"), env.getProperty("amazon.secret-key"))))
				.build();
	}

	@Override
	public Boolean uploadFile(Path targetLocation, String docId, Long id) {
		boolean status = false;
		bucketName = env.getProperty(BUCKET_ENV_STR);

		logger.debug(" #### Upload Document To S3Bucket --> " + bucketName);
		try (BufferedInputStream buffInputStream = new BufferedInputStream(
				new FileInputStream(targetLocation.toFile()))) {
			ObjectMetadata metaData = new ObjectMetadata();
			metaData.setContentLength(buffInputStream.available());
			File file = targetLocation.toFile();
			String key = 12 + "/" + file.getName();
			DocumentResponseFromS3 response = getDocumentResponse(key);
			if (response != null) {
				PutObjectResult putObj = amazonS3Client.putObject(bucketName, key, buffInputStream, metaData);
				logger.info(" #### Upload Document :: uploadDocumentToS3Bucket :: putObjectResult.getETag()  --> "
						+ putObj);
			}

			logger.info(" #### Upload Document :: uploadDocumentToS3Bucket :: putObjectResult.getETag()  --> "
					+ response.toString());
			status = true;
		} catch (Exception io) {
			logger.info("IOException" + io);
		}
		return status;
	}

	private DocumentResponseFromS3 getDocumentResponse(String key) {
		DocumentResponseFromS3 response = new DocumentResponseFromS3();
		S3Object s3object = amazonS3Client.getObject(key, bucketName);
		response.setEtag(s3object.getObjectMetadata().getETag());
		response.setOwner(s3object.getKey());
		response.setUrl(s3object.getObjectContent().getHttpRequest().getURI().toString());
		response.setLastModifiedDate(s3object.getObjectMetadata().getLastModified().toInstant().toString());
		return response;
	}

	@Override
	public Boolean deleteDocumentFromS3Bucket(String docKey) {
		boolean status = false;
		String documentName = docKey.substring(docKey.indexOf("/")+1);
		try {
			amazonS3Client.deleteObject(env.getProperty(BUCKET_ENV_STR), documentName);
			status= true;
		}catch(AmazonServiceException ae) {
			logger.info(" ### Delete DocumentFromS3Bucket error [" + ae.getMessage() + "] occurred while removing ["
					+ documentName + "] ");
		}
		return status;
	}

}
