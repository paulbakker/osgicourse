package greeter.test;

import junit.framework.TestCase;

import org.example.greeter.Greeter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class ExampleTest extends TestCase {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    public void testExample() throws Exception {

    	ServiceReference<Greeter> ref = context.getServiceReference(Greeter.class);
    	Greeter service = context.getService(ref);
    	assertEquals("Default hello", service.greet());
    	
    	
    	
    }
}
