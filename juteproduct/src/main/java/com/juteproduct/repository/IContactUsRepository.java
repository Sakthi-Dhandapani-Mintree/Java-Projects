package com.juteproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juteproduct.entity.ContactUs;
@Repository
public interface IContactUsRepository extends JpaRepository<ContactUs, Integer> {
	ContactUs findByContactEmailAddress(String emailAddress);

	ContactUs findByContactPhoneNumber(String phoneNumber);
}
