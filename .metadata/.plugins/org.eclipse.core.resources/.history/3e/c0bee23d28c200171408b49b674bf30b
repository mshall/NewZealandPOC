package com.cubeshub.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cubeshub.domain.Shops;

@Repository
public interface ShopsRepository extends MongoRepository<Shops, String> {

	public Shops findByAddress_PostcodeOrAddress_TownIgnoreCase(String postcode,String town);
	
}
