package multigreeter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.dm.annotation.api.Start;
import org.apache.felix.dm.annotation.api.Stop;
import org.example.greeter.Greeter;
import org.osgi.framework.ServiceReference;

@Component
public class MultiGreeter {
	private final Map<ServiceReference, Greeter> greeters = new ConcurrentHashMap<>();
	private volatile boolean running = true;

	@ServiceDependency(removed="removeGreeter")
	public void addGreeter(ServiceReference ref, Greeter greeter) {
		greeters.put(ref, greeter);
	}

	public void removeGreeter(ServiceReference ref) {
		greeters.remove(ref);
	}
	
	@Start
	public void start() {
		

		new Thread() {

			@Override
			public void run() {
								
				while(running) {
					System.out.println("Nr of greeters: " + greeters.size());
					for(Greeter greeter: greeters.values()) {
						String greet = greeter.greet();
						System.out.println(greet);
					}

					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}.start();
		
	}
	
	@Stop
	public void stop() {
		running = false;
	}
}
