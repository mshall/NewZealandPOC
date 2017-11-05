package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cubeshub.dto.Address;
import com.cubeshub.dto.Opening;
import com.cubeshub.dto.Services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "shops")
@Data
public class Shops {
	@Id
	private String _id;
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

}