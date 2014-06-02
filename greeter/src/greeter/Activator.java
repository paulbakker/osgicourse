package greeter;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.apache.felix.service.command.CommandProcessor;
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

		Properties properties = new Properties();
		properties.put(CommandProcessor.COMMAND_SCOPE, "demo");
		properties.put(CommandProcessor.COMMAND_FUNCTION, new String[] {"greet"});
		
		dm.add(createComponent().setInterface(Object.class.getName(), properties)
				.setImplementation(Greeter.class).add(
				createServiceDependency().setService(Hello.class).setCallbacks("addHello", "removeHello")));

	}

}
