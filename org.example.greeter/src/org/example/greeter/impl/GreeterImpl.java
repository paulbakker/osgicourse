package org.example.greeter.impl;

import java.util.Dictionary;

import org.example.greeter.Greeter;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class GreeterImpl implements Greeter, ManagedService{

	private volatile String message = "Default hello";
	
	@Override
	public String greet() {
		return message;
	}

	@Override
	public void updated(Dictionary<String, ?> properties)
			throws ConfigurationException {
		
		System.out.println("Updated!");

		String message = (String)properties.get("message");
		
		if(message == null) {
			throw new ConfigurationException("message", "Required property message was undefined");
		}
		
		this.message = message;
		
	}

	

}
