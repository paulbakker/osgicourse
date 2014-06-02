package greeter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.framework.ServiceReference;

import demo.Hello;

public class Greeter {
	
	
	private final Map<ServiceReference, Hello> helloServices = new ConcurrentHashMap<>();
	
	
	public void addHello(ServiceReference ref, Hello hello) {
		helloServices.put(ref, hello);
	}
	
	public void removeHello(ServiceReference ref) {
		helloServices.remove(ref);
	}
	
	
	public void greet() {
		
		for(Hello hello : helloServices.values()) {
			String helloMessage = hello.getHelloMessage();
			System.out.println(helloMessage);
		}
		
	}
}
