package mongodb1;

import org.bson.Document;

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
		
		Document document = new Document("name", "Daeshan");
		document.append("Sex", "Male");
		document.append("Age", "21");
		document.append("Race", "African-American");
		
		collection.insertOne(document);
	}
}

// https://www.youtube.com/watch?v=L5ORfm4i350&list=PLdnyVeMcpY7_Q3ms_ykCBgXOeCFGDleS2&index=1
// https://www.youtube.com/watch?v=YbB6yjJSoKs&list=PLdnyVeMcpY7_Q3ms_ykCBgXOeCFGDleS2&index=2