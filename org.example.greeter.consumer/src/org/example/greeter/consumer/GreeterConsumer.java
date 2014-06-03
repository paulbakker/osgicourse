package org.example.greeter.consumer;

import java.util.concurrent.TimeUnit;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.dm.annotation.api.Start;
import org.apache.felix.dm.annotation.api.Stop;
import org.example.greeter.Greeter;

@Component
public class GreeterConsumer {

	@ServiceDependency
	private volatile Greeter greeter;
	
	private volatile boolean running = true;
	
	@Start
	public void start() {
		
		new Thread() {

			@Override
			public void run() {
				
				while(running) {
					String greet = greeter.greet();
					System.out.println(greet);
					
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
