package webshop.products.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.fasterxml.jackson.databind.ObjectMapper;

import webshop.products.Product;
import webshop.products.ProductService;


public class ProductServlet extends HttpServlet {
	
	private volatile ProductService productService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String category = req.getParameter("category");
		
		resp.setContentType("application/json");
		
		List<Product> list = productService.list(category);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(list);
		
		resp.getWriter().write(json);
	}
}
