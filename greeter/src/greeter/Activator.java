package greeter;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import demo.Hello;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext arg0, DependencyManager dm) throws Exception {

		dm.add(createComponent().setImplementation(Greeter.class).add(
				createServiceDependency().setService(Hello.class).setRequired(true)));

	}

}
