package org.example.greeter.impl;

import java.util.Dictionary;
import java.util.List;

import org.example.greeter.Greeter;
import org.example.greeter.MyOtherService;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.log.LogService;

public class GreeterImpl implements Greeter, ManagedService {

	private volatile String message = "Default hello";

	private volatile LogService logService;

	@Override
	public String greet() {

		logService
				.log(LogService.LOG_INFO, "Greeting with message: " + message);


		return message;

	}

	@Override
	public void updated(Dictionary<String, ?> properties)
			throws ConfigurationException {

		System.out.println("Updated!");

		String message = (String) properties.get("message");

		if (message == null) {
			throw new ConfigurationException("message",
					"Required property message was undefined");
		}

		this.message = message;

	}

}
