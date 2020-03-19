package com.resoursetechmappings.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resoursetechmappings.entity.ResourceBean;

@Repository
public interface ResourceServiceRepo extends JpaRepository<ResourceBean, Long> {

}
