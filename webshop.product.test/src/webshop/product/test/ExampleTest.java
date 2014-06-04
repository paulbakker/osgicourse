package webshop.product.test;

import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;
import org.amdatu.mongo.MongoDBService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import webshop.products.Product;
import webshop.products.ProductService;

public class ExampleTest extends BaseOSGiServiceTest<ProductService> {

	private volatile MongoDBService mongoDBService;

	public ExampleTest() {
		super(ProductService.class);
	}

	@Override
	public void setUp() throws Exception {

		addServiceDependencies(MongoDBService.class);

		Properties props = new Properties();
		props.put("dbName", "florida");
		configureFactory("org.amdatu.mongo", props);

		super.setUp();

		mongoDBService.getDB().getCollection("products")
				.remove(new BasicDBObject());

	}

	public void testSave() throws Exception {
		
		long count = mongoDBService.getDB().getCollection("products").count();
		assertEquals(0, count);
		
		createProduct();
		
		count = mongoDBService.getDB().getCollection("products").count();
		assertEquals(1, count);
	}

	private void createProduct() {
		Product product = new Product();
		product.setName("Test product");
		instance.save(product);
	}
	
	public void testList() {
		createProduct();
		createProduct();
		
		List<Product> list = instance.list();
		assertEquals(2, list.size());
	}
	
	public void testFilterByCategory() {
		Product product = new Product();
		product.setName("Test book");
		product.setCategory("Books");
		instance.save(product);
		
		Product product2 = new Product();
		product2.setName("Test game");
		product2.setCategory("games");
		instance.save(product2);
		
		List<Product> list = instance.list("Books");
		assertEquals(1, list.size());
	}
}
