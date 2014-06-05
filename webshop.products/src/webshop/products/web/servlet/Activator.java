package webshop.products.web.servlet;

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

		dm.add(createComponent()
				.setInterface(Object.class.getName(), null)
				.setImplementation(ProductServlet.class)
				.add(createServiceDependency().setService(HttpService.class)
						.setRequired(true))
				.add(createServiceDependency().setService(ProductService.class)
						.setRequired(true)));
	}

}
