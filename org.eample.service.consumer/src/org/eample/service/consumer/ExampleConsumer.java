package org.eample.service.consumer;

import org.example.service.provider.Example;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ExampleConsumer implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {

		ServiceReference<Example> serviceReference = context.getServiceReference(Example.class);

		if (serviceReference != null) {
			try {
				Example service = context.getService(serviceReference);

				if (service != null) {
					String doSomething = service.doSomething();
					System.out.println(doSomething);
				}
			} finally {
				context.ungetService(serviceReference);
			}
		}


	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
