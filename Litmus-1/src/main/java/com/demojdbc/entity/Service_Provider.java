package com.demojdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service_Provider {
	private int hr_id;
	private String status;
	private String remarks;
	private String cancel_reason;
	private int current_date;

}
