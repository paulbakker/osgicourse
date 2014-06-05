package webshop.products.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import webshop.products.Product;
import webshop.products.ProductService;

@Path("products")
public class ProductResource {
	
	private volatile ProductService productService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> list() {
		return productService.list();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("cat/{category}")
	public List<Product> list(@PathParam("category") String category, @QueryParam("maxprice") double maxPrice) {
		System.out.println("Maxprice: " + maxPrice);
		
		return productService.list(category);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Product product) throws URISyntaxException {
		productService.save(product);
		System.out.println("Saved product " + product);
		
		ResponseBuilder ok = Response.ok();
		ok.location(new URI("products/" + product.get_id()));
		return ok.build();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{productId}")
	public void update(Product product, @PathParam("productId") String productId) {
		System.out.println("Updating product: " + productId);
		
		product.set_id(productId);
		productService.save(product);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{productId}")
	public Product get(@PathParam("productId") String productId) {
		Product product = new Product();
		product.set_id(productId);
		return product;
	}
	
	
}
