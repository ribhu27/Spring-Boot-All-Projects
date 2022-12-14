package com.jdbcdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbcdemo.entity.Hire_Request;

@Repository
public class Hire_RequestRepositoryImpl {

	private static final String INSERT_Hire_Request_QUERY = "INSERT INTO Hire_Request(hr_id,customer_id,sp_id,service_id,rate,location,status,pet_id,job_date_time,duration,remarks,cancel_reason) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_Hire_Request_BY_HR_ID_QUERY = "UPDATE Hire_Request SET customer_id=?,sp_id=?,service_id=?,rate=?,location=?,status=?,pet_id=?,job_date_time=?,duration=?,remarks=?,cancel_reason=? WHERE HR_ID=?";
    private static final String GET_Hire_Request_BY_HR_ID_QUERY = "SELECT * FROM Hire_Request WHERE HR_ID=?";
    private static final String DELETE_Hire_Request_BY_HR_ID = "DELETE FROM Hire_Request WHERE HR_ID=?";
    private static final String GET_Hire_Requests_QUERY = "SELECT * FROM Hire_Request";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Hire_Request saveHire_Request(Hire_Request hire_request) {
		jdbcTemplate.update(INSERT_Hire_Request_QUERY,hire_request.getHr_id(), hire_request.getCustomer_id(), hire_request.getSp_id(), hire_request.getService_id(),hire_request.getRate(),hire_request.getLocation(),hire_request.getStatus(),hire_request.getPet_id(),hire_request.getJob_date_time(),hire_request.getDuration(),hire_request.getRemarks(),hire_request.getCancel_reason());
		return hire_request;
	}

	
	public Hire_Request updateHire_Request(Hire_Request hire_request) {
		jdbcTemplate.update(UPDATE_Hire_Request_BY_HR_ID_QUERY,hire_request.getCustomer_id(), hire_request.getSp_id(), hire_request.getService_id(),hire_request.getRate(),hire_request.getLocation(),hire_request.getStatus(),hire_request.getPet_id(),hire_request.getJob_date_time(),hire_request.getDuration(),hire_request.getRemarks(),hire_request.getCancel_reason(),hire_request.getHr_id());
        return hire_request; 
	}

	
	public Hire_Request getByHr_id(int hr_id) {
		return jdbcTemplate.queryForObject(GET_Hire_Request_BY_HR_ID_QUERY, (rs, rowNum) -> {
          
		 return new Hire_Request(rs.getInt("hr_id"),rs.getInt("customer_id"),rs.getInt("sp_id"),rs.getInt("service_id"),rs.getFloat("rate"),rs.getString("location"),rs.getString("status"),rs.getInt("pet_id"),rs.getString("job_date_time"),rs.getFloat("duration"),rs.getString("remarks"),rs.getString("cancel_reason"));
        },hr_id);
	}

	
	public String deleteByHr_id(int hr_id) {
		jdbcTemplate.update(DELETE_Hire_Request_BY_HR_ID, hr_id);
        return "Hire_Request got deleted with hr_id " + hr_id;
	}

	
	public List<Hire_Request> allHire_Requests() {
		return jdbcTemplate.query(GET_Hire_Requests_QUERY, (rs, rowNum) -> {
			 return new Hire_Request(rs.getInt("hr_id"),rs.getInt("customer_id"),rs.getInt("sp_id"),rs.getInt("service_id"),rs.getFloat("rate"),rs.getString("location"),rs.getString("status"),rs.getInt("pet_id"),rs.getString("job_date_time"),rs.getFloat("duration"),rs.getString("remarks"),rs.getString("cancel_reason"));
        });
	}

}