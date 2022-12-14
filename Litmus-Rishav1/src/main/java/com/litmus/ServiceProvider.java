package com.litmus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServiceProvider {
	
	private Integer hr_id ;
	private Integer customer_id;
	private Integer sp_id; 
	private Integer service_id; 
	private float rate; 
	private String location;
	private String status; 
	private Integer pet_id; 
	private Integer job_date_time;
	private float duration; 
	private String remarks;
	
	public ServiceProvider() {
	}
	public ServiceProvider(Integer hr_id, Integer customer_id, Integer sp_id, Integer service_id, float rate,
			String location, String status, Integer pet_id, Integer job_date_time, float duration, String remarks) {
		super();
		this.hr_id = hr_id;
		this.customer_id = customer_id;
		this.sp_id = sp_id;
		this.service_id = service_id;
		this.rate = rate;
		this.location = location;
		this.status = status;
		this.pet_id = pet_id;
		this.job_date_time = job_date_time;
		this.duration = duration;
		this.remarks = remarks;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getHr_id() {
		return hr_id;
	}
	public void setHr_id(Integer hr_id) {
		this.hr_id = hr_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPet_id() {
		return pet_id;
	}
	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}
	public Integer getJob_date_time() {
		return job_date_time;
	}
	public void setJob_date_time(Integer job_date_time) {
		this.job_date_time = job_date_time;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
}
