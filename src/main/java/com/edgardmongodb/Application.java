package com.edgardmongodb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Main Application Launcher located in the root package
 * Testing a NoSQL database : Mongodb
 * Using Maven 3.3+ for building the project 
 * And taking advantage of Java 1.8+ latest awesome new features  
 * 
 * @author edgardndouna
 */
public class Application {

	public static void main(String[] args) {
		
		try( ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")){
			
			MongoClient client = (MongoClient) context.getBean("mongoClient");
			
			DB db = client.getDB("sandbox");
			DBCollection dbCollection = db.getCollection("book");
			
			dbCollection.insert(new BasicDBObject().append("title", "David Copperfield"));
			dbCollection.insert(new BasicDBObject().append("title", "Henri David Thoreau"));
		}
		
	}
}


/*
 * 
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	MongoClient client = (MongoClient) context.getBean("mongoClient");
	DB db = client.getDB("sandbox");
	DBCollection collection = db.getCollection("book");
	collection.insert(new BasicDBObject().append("title", "Harry Potter")); 
 * 
 */
