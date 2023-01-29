package mongodb1;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

public class MongoMain {

	public static void main(String[] args) {
		String uri = "mongodb://localhost:27017";
		MongoClientURI clientURI = new MongoClientURI(uri);
		MongoClient mongoClient = new MongoClient(clientURI);

		MongoDatabase mongoDatabase = mongoClient.getDatabase("MongoDB");
		MongoCollection collection = mongoDatabase.getCollection("test");

		System.out.println("Base de datos conectada!");

		Block<Document> printBlock = document -> System.out.println(document.toJson());

		collection.aggregate(Arrays.asList(Aggregates.match(Filters.eq("Age", 33)),
				Aggregates.group("$Race", Accumulators.sum("count", 1)))).forEach(printBlock);
		
		System.out.println("Colección agregada.");
				
	}
}

// https://www.youtube.com/watch?v=yJrjs5GK3sM&list=PLdnyVeMcpY7_Q3ms_ykCBgXOeCFGDleS2&index=4