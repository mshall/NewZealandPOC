package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "PostalAddress")
@Data
public class PostalAddress {
	@Id
	private int id;
	private String street_address, building_name, building_number, town, county, country, sub_locality, sub_street,
			building_letter, street_suffix, postcode;
	private int geolocation;
}
