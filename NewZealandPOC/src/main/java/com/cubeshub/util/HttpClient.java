package com.cubeshub.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

	@Value("${town.shops.url}")
	String url;

	RestTemplate restTemplate = new RestTemplate();

	public <T> T callAPI(Class<T> clazz, String town) {
		url = url + "?town=" + town;

		T response = (T) restTemplate.getForObject(url, clazz);
		if (response != null) {
			System.out.println("Response for Get Request: " + response.toString());
		} else {
			System.out.println("Response for Get Request: NULL");
		}
		return response;
	}
}
