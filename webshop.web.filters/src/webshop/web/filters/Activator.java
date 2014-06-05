package webshop.web.filters;

import java.util.Properties;

import javax.servlet.Filter;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase {

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(BundleContext arg0, DependencyManager dm) throws Exception {

		Properties props = new Properties();
		props.put("pattern", "/.*");

		dm.add(createComponent().setInterface(Filter.class.getName(), props)
				.setImplementation(LogFilter.class));

	}

}
