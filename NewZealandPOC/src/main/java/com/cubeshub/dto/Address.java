package com.cubeshub.dto;

import lombok.Data;

@Data
public class Address {
	private String street;
	private String postcode;
	private String building_name;
	private String building_number;
	private String county;
	private String town;
	private String country;
	private Location location;
}
