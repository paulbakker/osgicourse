package webshop.products.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.amdatu.mongo.MongoDBService;
import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import webshop.products.Product;
import webshop.products.ProductService;

public class MongoProductService implements ProductService {

	private volatile MongoDBService dbService;
	private volatile DBCollection collection;
	private volatile JacksonDBCollection<Product, String> products;

	public void start() {
		collection = dbService.getDB().getCollection("products");

		products = JacksonDBCollection.wrap(collection, Product.class,
				String.class);
	}

	@Override
	public void save(Product product) {
		WriteResult<Product, String> save = products.save(product);
		
		String savedId = save.getSavedId();
		if(savedId != null) {
			product.set_id(savedId);
		}

	}

	@Override
	public List<Product> list() {

		DBCursor find = collection.find();
		List<Product> products = new ArrayList<Product>();

		while (find.hasNext()) {
			DBObject next = find.next();
			Product p = new Product();
			ObjectId objectId = (ObjectId) next.get("_id");
			p.set_id(objectId.toString());
			p.setName((String) next.get("name"));

			products.add(p);
		}

		return products;
	}

	@Override
	public List<Product> list(String category) {

		org.mongojack.DBCursor<Product> find = products.find(new BasicDBObject(
				"category", category));
		List<Product> products = new ArrayList<Product>();

		while (find.hasNext()) {
			products.add(find.next());
		}

		return products;
	}

}
