package org.example.greeter.impl;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.log.LogService;

@RunWith(MockitoJUnitRunner.class)
public class GreeterImplTest {

	@InjectMocks @Spy
	private GreeterImpl greeter = new GreeterImpl();
	
	@Mock
	private LogService logService;
	
	
	@Before
	public void setup() {
	}
	
	
	@Test
	public void testDefaultMessage() {
		String greet = greeter.greet();
		assertEquals("Default hello", greet);
	}
	
	@Test
	public void testConfigureMessage() throws ConfigurationException {
		
		Hashtable<String, Object> props = new Hashtable<String, Object>();
		props.put("message", "test message");
		
		greeter.updated(props);
		
		String greet = greeter.greet();
		
		assertEquals("test message", greet);
	}

	@Test(expected=ConfigurationException.class)
	public void testConfigurationError() throws ConfigurationException {
		Hashtable<String, Object> props = new Hashtable<String, Object>();
		props.put("somerandomstring", "test message");
		
		greeter.updated(props);
	}
}
