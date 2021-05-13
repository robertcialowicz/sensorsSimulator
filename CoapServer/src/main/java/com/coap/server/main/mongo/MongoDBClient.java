package com.coap.server.main.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;


public class MongoDBClient {
    private MongoClient mongoClient;
    private MongoDatabase database;

    private ConnectionString connString = new ConnectionString(
            System.getenv("MONGO_URL")
    );

    public MongoDBClient() throws UnknownHostException {

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("test");
    }

    private List<Document> collectionToList (MongoCollection<Document> collection) {
        List<Document> list = new ArrayList<>();

        collection.find().forEach(doc -> {
            Document document = (Document)doc;
            list.add(document);
        });
        return list;
    }

    public String getDataFromSensors() {
        MongoCollection<Document> coll1 = database.getCollection("temps1");
        MongoCollection<Document> coll2 = database.getCollection("temps2");
        MongoCollection<Document> coll3 = database.getCollection("temps3");
        MongoCollection<Document> coll4 = database.getCollection("temps4");

        Map<String, List<Document>> map = new HashMap<>();
        map.put("temps1", collectionToList(coll1));
        map.put("temps2", collectionToList(coll2));
        map.put("temps3", collectionToList(coll3));
        map.put("temps4", collectionToList(coll4));

        return new Gson().toJson(map);
    }


    public static void main(String[] args) throws UnknownHostException {
        MongoDBClient mongoDBClient = new MongoDBClient();
        mongoDBClient.getDataFromSensors();
    }
}
