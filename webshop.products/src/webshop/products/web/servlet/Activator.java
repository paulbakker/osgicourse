package webshop.products.web.servlet;

import java.util.Properties;

import javax.servlet.Servlet;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;

import webshop.products.ProductService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext bc, DependencyManager dm) throws Exception {

		Properties props = new Properties();
		props.put("alias", "/products");
		
		dm.add(createComponent()
				.setInterface(Servlet.class.getName(), props)
				.setImplementation(ProductServlet.class)
				.add(createServiceDependency().setService(ProductService.class)
						.setRequired(true)));
	}

}
