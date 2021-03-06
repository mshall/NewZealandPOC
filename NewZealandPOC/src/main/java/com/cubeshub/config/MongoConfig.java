package com.cubeshub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
//@PropertySource("classpath:mongo.properties")
@EnableMongoRepositories("com.cubeshub")
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.host}")
	private String hostName;

	@Value("${spring.data.mongodb.port}")
	private int port;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	} 

	@Override
	public @Bean Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient(hostName, port);
	}

//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), databaseName);
//    }
    
	@Override
	protected String getMappingBasePackage() {
		return "com.vis.poc";
	}

}
