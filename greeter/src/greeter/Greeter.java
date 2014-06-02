package greeter;

import demo.Hello;

public class Greeter {
	
	private volatile Hello hello;
	
	public void start() {
		
		String helloMessage = hello.getHelloMessage();
		if(helloMessage == null) {
			System.out.println("Default message");
		} else {
			System.out.println(helloMessage);
		}
		
		
		
	}
}
