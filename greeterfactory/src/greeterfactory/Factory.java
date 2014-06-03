package greeterfactory;

import java.util.Dictionary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyManager;
import org.example.greeter.Greeter;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;

public class Factory implements ManagedServiceFactory{

	private volatile DependencyManager dm;
	private final Map<String, Component> components = new ConcurrentHashMap<String, Component>();
	
	
	@Override
	public String getName() {
		return "greeter factory";
	}

	@Override
	public void updated(String pid, Dictionary properties)
			throws ConfigurationException {

		
		String message = (String)properties.get("message");
		
		Component component = dm.createComponent().setInterface(Greeter.class.getName(), null).setImplementation(new GreeterImpl(message));
		
		components.put(pid, component);
		
		dm.add(component);
		System.out.println("Configured new Greeter!");
	}

	@Override
	public void deleted(String pid) {
		
		Component remove = components.remove(pid);
		dm.remove(remove);
	}

}
