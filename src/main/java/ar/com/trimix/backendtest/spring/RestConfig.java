package ar.com.trimix.backendtest.spring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ar.com.trimix.backendtest.exception.AlreadyExistsExceptionHandler;
import ar.com.trimix.backendtest.exception.NotFoundExceptionHandler;
import ar.com.trimix.backendtest.rest.PersonaResource;

@ApplicationPath("/api")
public class RestConfig extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(PersonaResource.class, NotFoundExceptionHandler.class, AlreadyExistsExceptionHandler.class));
    }
}