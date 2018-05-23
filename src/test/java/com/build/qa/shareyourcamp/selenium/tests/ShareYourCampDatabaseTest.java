package com.build.qa.shareyourcamp.selenium.tests;

import java.util.Iterator;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class ShareYourCampDatabaseTest {

	
	@Test
	public void DatabaseTest() throws Exception{
		try{   
	    	  
			//Connecting to the mongoDB instance
		        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://glenn:pepper@ds115035.mlab.com:15035/shareyourcamp");
				@SuppressWarnings("resource")
				MongoClient mongoClient = new MongoClient( mongoClientURI );
		        
			//Selecting the database
		        @SuppressWarnings("deprecation")
				DB db = mongoClient.getDB("shareyourcamp");
			
		        //Selecting the collection
		        @SuppressWarnings("unchecked")
				DBCollection collection = db.getCollection("users");
		        BasicDBObject searchQuery = new BasicDBObject();
		        searchQuery.get("username");
		        DBCursor iterDoc = collection.find(searchQuery); 
		        int i = 1; 

		        // Getting the iterator 
		        Iterator<DBObject> it = iterDoc.iterator(); 
		      
		        while (it.hasNext()) {  
		           System.out.println(it.next());  
		        i++; 
		        
		        }
		}catch(Exception e){
			throw e;
		}
	}}
	
		   
	

