package com.litmus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService {
	
	@Autowired
	private ServiceProviderRepository repo;
	
	public List<ServiceProvider> listAll() {
		return repo.findAll();
	}
	
	public void save(ServiceProvider serviceprovider) {
    	repo.save(serviceprovider);
    }
	
	public ServiceProvider get(Integer id) {
	    	return repo.findById(id).get();
	}
	    
	public void delete(Integer id) {
	    	repo.deleteById(id);
	}
}
