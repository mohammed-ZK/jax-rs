
import exception.GenericExceptionMapper;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import rest.ProductResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class HelloApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ProductResource.class);
        classes.add(GenericExceptionMapper.class);
        return classes;
    }
}
