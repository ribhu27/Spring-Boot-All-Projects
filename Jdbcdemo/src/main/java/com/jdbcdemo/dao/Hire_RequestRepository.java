package com.jdbcdemo.dao;

import java.util.List;

import com.jdbcdemo.entity.Hire_Request;

public interface Hire_RequestRepository {
	    Hire_Request savehire_request(Hire_Request hire_request);

	    Hire_Request updateHire_Request(Hire_Request hire_request);

	    Hire_Request getByHr_id(int hr_id);

	    String deleteByHr_id(int hr_id);

	    List<Hire_Request> allHire_Requests();

}