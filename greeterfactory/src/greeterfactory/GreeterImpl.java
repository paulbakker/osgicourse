package greeterfactory;

import org.example.greeter.Greeter;

public class GreeterImpl implements Greeter {

	private final String message;

	public GreeterImpl(String message) {
		this.message = message;
	}

	@Override
	public String greet() {

		return message;
	}

}
