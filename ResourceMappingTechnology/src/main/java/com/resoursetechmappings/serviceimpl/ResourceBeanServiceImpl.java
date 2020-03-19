package com.resoursetechmappings.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resoursetechmappings.entity.ResourceBean;
import com.resoursetechmappings.repo.ResourceServiceRepo;
import com.resoursetechmappings.service.ResourceBeanService;

@Service
public class ResourceBeanServiceImpl implements ResourceBeanService {
private Logger logger = LoggerFactory.getLogger(ResourceBeanServiceImpl.class);
	@Autowired
	private ResourceServiceRepo resourceServiceRepo;
	@Override
	public boolean addResourece(ResourceBean resource) {
		logger.info("Resource going to add into DB");
		boolean result = false;
		ResourceBean resourceBean = resourceServiceRepo.save(resource);
		if(resourceBean !=null) {
			
			result = true;
			logger.info("Resource going to added into DB");
		}
		return result;
	}

	@Override
	public int updateResource(ResourceBean resource) {
		return 0;
	}

	@Override
	public ResourceBean getResource(int id) {
		long ids = id;
		Optional<ResourceBean> res=  resourceServiceRepo.findById(ids);
		if(res.isPresent()) {
			return res.get();
		}
		return null;
	}

	@Override
	public int removeResource(int id) {
		return 0;
	}

}
