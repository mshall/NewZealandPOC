package com.cubeshub.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "GeographicLocation")
@Data
public class GeographicLocation {

	@Id
	private int id;
	private double altitude_measure, latitude_measure, longitude_measure;

}
