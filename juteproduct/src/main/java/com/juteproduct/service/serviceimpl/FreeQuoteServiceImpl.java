package com.juteproduct.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juteproduct.entity.FreeQuote;
import com.juteproduct.repository.IFreeQuoteRepository;
import com.juteproduct.service.IFreeQuoteService;

@Service
public class FreeQuoteServiceImpl implements IFreeQuoteService {

	@Autowired
	private IFreeQuoteRepository freeQuoteRepo;

	@Override
	public List<FreeQuote> getAllFreeQuote() {
		return freeQuoteRepo.findAll();
	
	}

	@Override
	public FreeQuote addFreeQuotes(FreeQuote freeQuote) {
		return freeQuoteRepo.save(freeQuote);
	}
	

}
