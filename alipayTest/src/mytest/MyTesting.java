package mytest;

import java.util.Iterator;
import java.util.ServiceLoader;

import javax.imageio.spi.ServiceRegistry;

public class MyTesting {

    public static void main(String[] args) {
        ServiceLoader<MyTestInterface> load = ServiceLoader.load(MyTestInterface.class);
        Iterator<MyTestInterface> iterator = load.iterator();
        while(iterator.hasNext()) {
            MyTestInterface next = iterator.next();
            System.out.println(next.getClass().getName());
        }
        Iterator<MyTestInterface> lookupProviders = ServiceRegistry.lookupProviders(MyTestInterface.class);
        while(lookupProviders.hasNext()) {
            MyTestInterface next = lookupProviders.next();
            System.out.println(next.getClass().getName());
        }
        
    }
}
