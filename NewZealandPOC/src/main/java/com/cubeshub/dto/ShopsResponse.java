package com.cubeshub.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ShopsResponse {

	private String name;
	private String description;
	@Getter
	@Setter
	private String type;
	private String status;
	private String ownership;
	private String email;
	private String telephone;
	private Address address;
	private Services[] services;
	private Opening[] opening;

	public boolean isNotNull() {
		if (name == null || description == null || type == null || address == null)
			return false;
		return true;

	}

}
