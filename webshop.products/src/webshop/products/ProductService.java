package webshop.products;

import java.util.List;

public interface ProductService {
	
	void save(Product product);
	List<Product> list();
	
	List<Product> list(String category);
}
