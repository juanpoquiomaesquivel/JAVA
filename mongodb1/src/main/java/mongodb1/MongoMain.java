package mongodb1;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoMain {

	public static void main(String[] args) {
		String uri = "mongodb://localhost:27017";
		MongoClientURI clientURI = new MongoClientURI(uri);
		MongoClient mongoClient = new MongoClient(clientURI);
		
		MongoDatabase mongoDatabase = mongoClient.getDatabase("MongoDB");
		MongoCollection collection = mongoDatabase.getCollection("test");
		
		System.out.println("Base de datos conectada!");
		
		Document found = (Document) collection.find(new Document("name", "Daeshan")).first();
		
		if (found != null) {
			System.out.println("Found User!");
			
			Bson updatedValue = new Document("Age", 33);
			Bson updateOperation = new Document("$set", updatedValue);
			collection.updateOne(found, updateOperation);
			System.out.println("User updated!");
		}
	}
}

// https://www.youtube.com/watch?v=RRVtfE165qo&list=PLdnyVeMcpY7_Q3ms_ykCBgXOeCFGDleS2&index=3