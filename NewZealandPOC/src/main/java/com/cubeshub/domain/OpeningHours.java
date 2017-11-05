package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "OpeningHours")
@Data
public class OpeningHours {
	@Id
	private int id;
	private String opening, closing, day;
}
