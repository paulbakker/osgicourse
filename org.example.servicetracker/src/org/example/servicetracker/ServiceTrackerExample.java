package org.example.servicetracker;

import java.util.concurrent.TimeUnit;

import org.example.service.provider.Example;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ServiceTrackerExample implements BundleActivator {
    private ServiceTracker tracker;

    @Override
    public void start(BundleContext context) throws Exception {
        tracker = new ServiceTracker(context,
            context.createFilter("(objectClass=" + Example.class.getName() +
                ")"), null);
        tracker.open();
        System.out.println("opened tracker");
        new Thread() {
            @Override
            public void run() {
                while(true) {
                	Example greeter = (Example)tracker.getService();
                    if(greeter != null) {
                        System.out.println(greeter.doSomething());
                    } else {
                        System.out.println("No greeter available");
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        tracker.close();
    }
}