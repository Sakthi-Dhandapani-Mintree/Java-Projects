package com.juteproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juteproduct.entity.FreeQuote;

@Repository
public interface IFreeQuoteRepository extends JpaRepository<FreeQuote, Long>{

}
