package com.cubeshub.service;

import com.cubeshub.dto.ShopsResponse;

public interface ShopsService {
	public ShopsResponse getShopsByTown(String town);
}
