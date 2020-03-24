package com.juteproduct.service;

import java.nio.file.Path;

public interface IDocumentAwsService {
	Boolean uploadFile(Path targetLocation, String docId, Long id);

	Boolean deleteDocumentFromS3Bucket(String docKey);
}
