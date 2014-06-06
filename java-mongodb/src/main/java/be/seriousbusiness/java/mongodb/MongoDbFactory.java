package be.seriousbusiness.java.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDbFactory {
	private static final MongoClient mongoClient=null;
	
	public static final DB getDB(final String databaseName){
		return mongoClient.getDB(databaseName);
	}

}
