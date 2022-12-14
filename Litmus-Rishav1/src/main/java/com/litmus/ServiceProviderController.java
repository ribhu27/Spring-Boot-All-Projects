package com.litmus;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
	
	@Autowired
	private ServiceProviderService service;

	@GetMapping("service_provider")
	public List<ServiceProvider> list() {
		return service.listAll();
	}
	
	@GetMapping("/service_provider/{id}")
	public ResponseEntity<ServiceProvider> get(@PathVariable Integer id) {
		try {
		ServiceProvider serviceprovider = service.get(id);
		return new ResponseEntity<ServiceProvider>(serviceprovider,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<ServiceProvider>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/service_provider/{id}")
	public ResponseEntity<?> update(@RequestBody ServiceProvider serviceprovider,
			@PathVariable Integer id) {
		try {
		ServiceProvider existproduct=service.get(id);
		service.save(serviceprovider);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
}
