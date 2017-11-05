package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "RetailPremise")
@Data
public class RetailPremise {
	@Id
	private int id;
	private String name, description, telephone_no, fax_no, email;
	private int opening, address;
}
