package greeterexample.test;

import junit.framework.TestCase;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;
import org.example.greeter.Greeter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

public class ExampleTest extends BaseOSGiServiceTest<Greeter> {
	
	private volatile LogService log;
	
	public ExampleTest() {
		super(Greeter.class);
	}
	
	@Override
	public void setUp() throws Exception {
	
		addServiceDependencies(LogService.class);
		
		
		
		super.setUp();
	}
	

    public void testExample() throws Exception {
    		
    		String greet = instance.greet();
    		assertEquals("Default hello", greet);
    	
    }
}
