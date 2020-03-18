package com.juteproduct.service;

import java.util.List;

import com.juteproduct.entity.FreeQuote;

public interface IFreeQuoteService {
	List<FreeQuote> getAllFreeQuote();
	FreeQuote addFreeQuotes(FreeQuote freeQuote);
	
}
