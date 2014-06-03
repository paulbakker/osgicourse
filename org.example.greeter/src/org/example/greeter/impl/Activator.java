package org.example.greeter.impl;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.example.greeter.Greeter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.log.LogService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext bc, DependencyManager dm) throws Exception {
		
		Properties props = new Properties();
		props.put(Constants.SERVICE_PID, "org.example.greeter");

		dm.add(createComponent().setInterface(
				new String[] {Greeter.class.getName(), ManagedService.class.getName()}, props)
				.setImplementation(GreeterImpl.class).add(createServiceDependency().setService(LogService.class)));
	}

}
