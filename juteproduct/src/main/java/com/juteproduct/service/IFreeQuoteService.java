package com.juteproduct.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.juteproduct.entity.FreeQuote;

public interface IFreeQuoteService {
	List<FreeQuote> getAllFreeQuote();
	void uploadFile(MultipartFile  files);
}
