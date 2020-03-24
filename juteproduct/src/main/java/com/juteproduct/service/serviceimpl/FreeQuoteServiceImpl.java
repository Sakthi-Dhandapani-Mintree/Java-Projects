package com.juteproduct.service.serviceimpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.juteproduct.entity.FreeQuote;
import com.juteproduct.repository.IFreeQuoteRepository;
import com.juteproduct.service.IFreeQuoteService;

@Service
public class FreeQuoteServiceImpl implements IFreeQuoteService {
	private static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);
	private static final String FILEPATH = "D:\\logs\\New folder\\";
	@Autowired
	private IFreeQuoteRepository freeQuoteRepo;

	@Override
	public List<FreeQuote> getAllFreeQuote() {
		return freeQuoteRepo.findAll();

	}

	@Override
	public void uploadFile(MultipartFile file) {
		Path location = Paths
				.get("D:\\logs\\New folder1\\" + File.separator + 1234 + File.separator + file.getOriginalFilename());
		copyFileToTempLocation(file, location);

	}

	public void copyFileToTempLocation(MultipartFile file, Path location) {
		try (BufferedInputStream srcFileStream = new BufferedInputStream(file.getInputStream())) {
			Files.createDirectories(location);
			Files.copy(srcFileStream, location, StandardCopyOption.REPLACE_EXISTING);
			logger.info("Files moved tem location ::" + location.toFile().exists());
		} catch (IOException e) {
			logger.info("########## Document Prcoess IO Eception targetLocation ----> : " + e);
		} catch (Exception e) {
			logger.info("########## Document Prcoess Exception targetLocation ----> : " + e);
		}

	}

}
