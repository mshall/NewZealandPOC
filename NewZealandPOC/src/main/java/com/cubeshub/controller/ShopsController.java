package com.cubeshub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.cubeshub.dto.ShopsResponse;
import com.cubeshub.service.ShopsService;

@EnableWebMvc
@RestController
@RequestMapping("/v1/")
public class ShopsController {

	@Autowired
	ShopsService service;

	@RequestMapping(value = "shops", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ShopsResponse> findShopsByPostCode(@RequestParam(value="town", required = true) String town,
			@RequestParam(value = "postcode", required = false) String postcode) {
		ShopsResponse shops = service.getShopsByTown(town);
		return new ResponseEntity<ShopsResponse>(shops, HttpStatus.OK);
	}

}
