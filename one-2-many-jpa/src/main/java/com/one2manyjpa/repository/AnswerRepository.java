package com.one2manyjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.one2manyjpa.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
}
