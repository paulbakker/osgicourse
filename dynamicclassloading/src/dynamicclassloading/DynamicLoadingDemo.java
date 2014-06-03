package dynamicclassloading;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Start;

@Component
public class DynamicLoadingDemo {
	
	@Start
	public void load() {
		
		
		
		try {
			Class<?> forName = Class.forName("org.example.driver.ExampleDriver");
			System.out.println("Successfully loaded " + forName.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
