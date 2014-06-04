package webshop.products.mongo;

import org.amdatu.mongo.MongoDBService;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

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
				.setInterface(ProductService.class.getName(), null)
				.setImplementation(MongoProductService.class)
				.add(createServiceDependency().setService(MongoDBService.class)
						.setRequired(true)));
	}
}
