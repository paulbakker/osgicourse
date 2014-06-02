package demo.impl;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import demo.Hello;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
	}

	@Override
	public void init(BundleContext bc, DependencyManager dm) throws Exception {

		dm.add(createComponent().setInterface(Hello.class.getName(), null)
				.setImplementation(HelloImpl.class));

	}

}
