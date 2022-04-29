package com.company;
import com.company.model.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseController {
    static DatabaseController instance = new DatabaseController();
    MongoClient client;
    MongoDatabase db;
    public DatabaseController() {
        client = MongoClients.create("mongodb://localhost:27017/");
        db = client.getDatabase("supply_scheduler");

    }
    public static DatabaseController getInstance(){
        return instance;
    }

    public String registerConsumer(Consumer consumer){
        MongoCollection<Document> consumers = db.getCollection("consumers");
        Document current = new Document("username", consumer.getUsername())
                .append("password", consumer.getPassword())
                .append("email", consumer.getEmailId());
        Document d = consumers.find(current).first();
        if(d == null) {
            InsertOneResult res = consumers.insertOne(current);
            return res.getInsertedId().asObjectId().getValue().toString();
        } else return null;
    }

    public String loginConsumer(String username, String password){
        MongoCollection<Document> consumers = db.getCollection("consumers");
        Document d = consumers.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
        if(d != null) return d.get("_id").toString();
        MongoCollection<Document> producer = db.getCollection("producers");
        Document d1 = producer.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
        //System.out.println(d);
        if(d1 != null) return d1.get("_id").toString();
        return null;
    }

    public String registerProducer(Producer producer){
        MongoCollection<Document> producers = db.getCollection("producers");
        Document current = new Document("username", producer.getUsername())
                .append("password", producer.getPassword())
                .append("email", producer.getEmailId())
                .append("pname", producer.getProducerName())
                .append("paddress", producer.getProducerAddress());
        Document d = producers.find(current).first();
        if(d == null) {
            InsertOneResult res = producers.insertOne(current);
            return res.getInsertedId().asObjectId().getValue().toString();
        } else return null;
    }

    public String loginProducer(String username, String password){
        MongoCollection<Document> producers = db.getCollection("producers");
        Document d = producers.find(Filters.and(Filters.eq("username", username), Filters.eq("password", password))).first();
        System.out.println(d);
        if(d != null) return d.get("_id").toString();
        else return null;
    }

    public String storeSupply(String producer_id, Supply supply){
        //System.out.println(supply.getName());
        MongoCollection<Document> supplies = db.getCollection("supplies");
        Document current = new Document("producer_id", producer_id)
                .append("name", supply.getName())
                .append("cost", supply.getCost())
                .append("stock", supply.getStock());
        Document d = supplies.find(current).first();
        if(d==null){
            InsertOneResult res = supplies.insertOne(current);
            return res.getInsertedId().asObjectId().getValue().toString();
        } else return null;
    }

    public void deleteSupply(String supply_id){
        MongoCollection<Document> supplies = db.getCollection("supplies");
        ObjectId id = new ObjectId(supply_id);
        Document d = supplies.find(Filters.eq("_id", id)).first();
        System.out.println("None");
        if(d!=null) {
            System.out.println("None1");
            supplies.deleteOne(d);}
    }

    public ArrayList<Supply> getSupplies(){
        MongoCollection<Document> supplies = db.getCollection("supplies");
        FindIterable<Document> ds = supplies.find();
        return returnSupplies(ds);
    }

    public ArrayList<Supply> getSupplies(String producer_id){
        MongoCollection<Document> supplies = db.getCollection("supplies");
        FindIterable<Document> ds = supplies.find(Filters.eq("producer_id", producer_id));
        return returnSupplies(ds);
    }

    private ArrayList<Supply> returnSupplies(FindIterable<Document> ds) {
        ArrayList<Supply> out = new ArrayList<Supply>();
        if(ds == null) return null;
        for(Document d: ds){
            Supply new_supply = SupplyScheduler.getSupply(1, d.getString("name"), d.getInteger("cost"), d.getInteger("stock"));
            new_supply.setItem_id(d.getObjectId("_id").toString());
            out.add(new_supply);
        }
        return out;
    }

    public Supply returnSupply(String supply_id){
        MongoCollection<Document> supplies = db.getCollection("supplies");
        ObjectId id = new ObjectId(supply_id);
        Document d = supplies.find(Filters.eq("_id", id)).first();
        if(d == null) return null;
        Supply s = new Packaged(
                d.getString("name"),
                d.getInteger("cost"),
                d.getInteger("stock")
        );
        s.setItem_id(supply_id);
        return s;
    }

    public String storeRequirement(String consumer_id, Requirement requirement){
        MongoCollection<Document> requirements = db.getCollection("requirements");
        Document current = new Document("item_id", requirement.getItem().getItem_id())
                .append("consumer_id", consumer_id)
                .append("quantity", requirement.getQuantity())
                .append("totalCost", requirement.getTotalCost())
                .append("interval", requirement.getInterval());
        Document d = requirements.find(current).first();
        if(d == null) {
            InsertOneResult res = requirements.insertOne(current);
            return res.getInsertedId().asObjectId().getValue().toString();
        } else return null;
    }

    public String storeAdhoc(String consumer_id, Adhoc adhoc){
        MongoCollection<Document> adhocs = db.getCollection("adhocs");
        Document current = new Document("item_id", adhoc.getItem().getItem_id())
                .append("consumer_id", consumer_id)
                .append("quantity", adhoc.getQuantity())
                .append("totalCost", adhoc.getTotalCost())
                .append("address", adhoc.getAddress());
        Document d = adhocs.find(current).first();
        if(d == null) {
            InsertOneResult res = adhocs.insertOne(current);
            return res.getInsertedId().asObjectId().getValue().toString();
        } else return null;
    }

    public ArrayList<Requirement> getRequirements(String consumer_id){
        MongoCollection<Document> requirements = db.getCollection("requirements");
        FindIterable<Document> ds = requirements.find(Filters.eq("consumer_id", consumer_id));
        if(ds == null) return null;
        ArrayList<Requirement> req = new ArrayList<Requirement>();
        for(Document d: ds){
            Supply s = returnSupply(d.getString("item_id"));
            Requirement r = new Requirement(s, d.getInteger("quantity"));
            r.setId(d.getObjectId("_id").toString());
            req.add(r);
        }
        return req;
    }

    public void deleteRequirement(String req_id){
        MongoCollection<Document> requirements = db.getCollection("requirements");
        ObjectId id = new ObjectId(req_id);
        requirements.findOneAndDelete(Filters.eq("_id", id));
    }

    public void fullfillableRequirements(String producer_id){
        MongoCollection<Document> supplies = db.getCollection("supplies");
        MongoCollection<Document> requirements = db.getCollection("requirements");
        FindIterable<Document> ds = supplies.find(Filters.eq("producer_id", producer_id));
        ArrayList<Requirement> req = new ArrayList<Requirement>();
        for(Document d: ds){
            String supply_id = d.getObjectId("_id").toString();

        }
    }

    public String storeAdhoc(Consumer consumer){
        return null;
    }
}