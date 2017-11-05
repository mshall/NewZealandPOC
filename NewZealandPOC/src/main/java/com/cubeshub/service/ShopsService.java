package com.cubeshub.service;

import com.cubeshub.dto.ShopsResponse;

public interface ShopsService {
	public ShopsResponse getShopsByPostcodeAndTown(String postcode, String town);
}
