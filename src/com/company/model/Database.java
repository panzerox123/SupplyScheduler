package com.company.model;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Database {
    static Database instance = new Database();
    MongoClient client;
    MongoDatabase db;
    public Database() {
        client = MongoClients.create("mongodb://localhost:27017/");
        db = client.getDatabase("supply_scheduler");

    }
    public static Database getInstance(){
        return instance;
    }

    public Document registerConsumer(Consumer consumer){
        MongoCollection<Document> consumers = db.getCollection("consumers");
        Document current = new Document("username", consumer.getUsername())
                .append("password", consumer.getPassword())
                .append("email", consumer.getEmailId());
        Document d = consumers.find(current).first();
        if(d == null) {
            consumers.insertOne(current);
            return current;
        } else return null;
    }

    public Consumer loginConsumer(String username, String password){
        MongoCollection<Document> consumers = db.getCollection("consumers");
        Document d = consumers.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
        if(d != null) return new Consumer(d.get("username").toString(), d.get("password").toString(), d.get("email").toString());
        else return null;
    }

    public Document registerProducer(Producer producer){
        MongoCollection<Document> producers = db.getCollection("producers");
        Document current = new Document("username", producer.getUsername())
                .append("password", producer.getPassword())
                .append("email", producer.getEmailId())
                .append("pname", producer.getProducerName())
                .append("paddress", producer.getProducerAddress());
        Document d = producers.find(current).first();
        if(d == null) {
            producers.insertOne(current);
            return current;
        } else return null;
    }

    public Document loginProducer(String username, String password){
        MongoCollection<Document> producers = db.getCollection("consumers");
        Document d = producers.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
        if(d != null) return d;
        else return null;
    }
}
