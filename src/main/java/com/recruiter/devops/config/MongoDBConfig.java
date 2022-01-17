package com.recruiter.devops.config;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.recruiter.devops")
public class MongoDBConfig extends AbstractMongoClientConfiguration
{

	private static final String DATABASENAME = "Demo";
	
	@Override
    protected String getDatabaseName()
	{
        return DATABASENAME;
    }
 
    @Override
    public MongoClient mongoClient()
    {
    	String DATABASECONNECTION;
		try {
//			username = demouser
//			password = demo@123
			
			DATABASECONNECTION = "mongodb://demouser:" + 
			URLEncoder.encode("demo@123", StandardCharsets.UTF_8.toString()) + "@cluster0.vciap.mongodb.net/";
			ConnectionString connectionString = new ConnectionString(DATABASECONNECTION + DATABASENAME);
	        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	            .applyConnectionString(connectionString)
	            .build();
	        
	        return MongoClients.create(mongoClientSettings);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
        return null;
    }
 
	@Override
    public Collection getMappingBasePackages()
    {
        return Collections.singleton("com.recruiter.devops");
    }
}
