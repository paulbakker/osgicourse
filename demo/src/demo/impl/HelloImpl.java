package demo.impl;

import demo.Hello;

public class HelloImpl implements Hello{

	@Override
	public String getHelloMessage() {
		return "Hello from service!";
	}

}
