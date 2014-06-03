package greeterfactory;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedServiceFactory;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext arg0, DependencyManager dm)
			throws Exception {
		// TODO Auto-generated method stub
		
		Properties props = new Properties();
		props.put(Constants.SERVICE_PID, "org.example.greeterfactory");
		dm.add(createComponent().setInterface(ManagedServiceFactory.class.getName(), props).setImplementation(Factory.class));
		
	}
}
