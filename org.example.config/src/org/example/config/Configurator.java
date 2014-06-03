package org.example.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.dm.annotation.api.Start;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

@Component
public class Configurator {
	@ServiceDependency
	private volatile ConfigurationAdmin configurationAdmin;

	private final List<String> messages = Arrays
			.asList("Hamburgers, contains all the nutricion a healthy breakfast needs",
					"I know Kung Fu....",
					"English, motherfucker, do you speak it?",
					"I'll be back.",
					"My Mama always said, 'Life was like a box of chocolates; you never know what you're gonna get.");

	@Start
	public void start() {

		new Thread() {

			@Override
			public void run() {
				while (true) {
					try {
						Configuration configuration = configurationAdmin.getConfiguration("org.example.greeter",null);

						Hashtable<String, String> props = new Hashtable<>();
						Double index = Math.random() * messages.size();
						props.put("message", messages.get(index.intValue()));

						configuration.update(props);
						
						
						System.out.println("Configuring...");
						TimeUnit.SECONDS.sleep(5);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();

	}
}
