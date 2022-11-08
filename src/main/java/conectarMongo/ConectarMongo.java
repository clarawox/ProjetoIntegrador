package conectarMongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConectarMongo {
    String database ="pedidosDS";
    String collection ="DSDB";
    
    public void getValues(){
        System.out.println("getValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);
        for (Document doc:docs.find()){
            System.out.println("item: "+doc);
        }
    }
    
    public void insertValues(String nome, String numero, String donut, String bebida, String desc, float valor){
        System.out.println("Insert values");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);
        Document docBuilder = new Document();
        docBuilder.append("Nome", nome);
        docBuilder.append("Numero", numero);
        docBuilder.append("Donuts", donut);
        docBuilder.append("Bebida", bebida);
        docBuilder.append("Descrição", desc);
        docBuilder.append("Valor", valor);
        docs.insertOne(docBuilder);
    }
    
}
