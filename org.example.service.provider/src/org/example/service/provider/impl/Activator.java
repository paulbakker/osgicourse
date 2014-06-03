package org.example.service.provider.impl;

import org.example.service.provider.Example;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(Example.class.getName(), new ExampleImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

}
