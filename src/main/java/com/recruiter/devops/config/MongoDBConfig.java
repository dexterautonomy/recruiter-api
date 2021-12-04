package com.recruiter.devops.config;

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
	private static final String DATABASECONNECTION = "mongodb://demouser:demo@123@cluster0.vciap.mongodb.net/";
	
	@Override
    protected String getDatabaseName()
	{
        return DATABASENAME;
    }
 
    @Override
    public MongoClient mongoClient()
    {
        ConnectionString connectionString = new ConnectionString(DATABASECONNECTION + DATABASENAME);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 
	@Override
    public Collection getMappingBasePackages()
    {
        return Collections.singleton("com.recruiter.devops");
    }
}
