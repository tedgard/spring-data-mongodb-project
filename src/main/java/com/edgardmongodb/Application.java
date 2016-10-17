package com.edgardmongodb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Application {

	public static void main(String[] args) {
		
		try( ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("application-context.xml")){
			
			MongoClient client = (MongoClient) context.getBean("mongoClient");
			
			DB db = client.getDB("sandbox");
			DBCollection dbCollection = db.getCollection("book");
			dbCollection.insert(new BasicDBObject().append("title", "David Copperfield"));
		}
		
	}
}


/*
 * 
 *
 * ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client = (MongoClient) context.getBean("mongoClient");
		DB db = client.getDB("sandbox");
		DBCollection collection = db.getCollection("book");
		collection.insert(new BasicDBObject().append("title", "Harry Potter"));
 * 
 * 
 */
