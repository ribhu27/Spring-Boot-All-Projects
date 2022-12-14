package com.jdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hire_Request {
	private int hr_id;
	private int customer_id;
	private int sp_id;
	private int service_id;
	private float rate;
	private String location;
    private String status;
    private int pet_id;
	private String job_date_time;
	private float duration;
    private String remarks;
    private String cancel_reason;   
}