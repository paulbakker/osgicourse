package otherhello;

import org.apache.felix.dm.annotation.api.Component;

import demo.Hello;

@Component
public class OtherHelloService implements Hello{

	@Override
	public String getHelloMessage() {

		return "Other hello!";
	}

}
