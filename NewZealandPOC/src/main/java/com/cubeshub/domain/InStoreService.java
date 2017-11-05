package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "InStoreService")
@Data
public class InStoreService {

	@Id
	private int id;
	private int retail;
	private String type, description, url;

}
