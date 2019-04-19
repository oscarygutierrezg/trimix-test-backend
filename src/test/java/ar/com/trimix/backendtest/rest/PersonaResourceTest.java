package ar.com.trimix.backendtest.rest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.Application;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.trimix.backendtest.spring.PersistenceXmlConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceXmlConfig.class)
public class PersonaResourceTest {

    
	private static final String SERVICE_URL = "http://localhost:9998/backendtest/api/personas";

    @Test
    public void givenGetAllEmployees_whenCorrectRequest_thenResponseCodeSuccess() throws IOException {
        final HttpUriRequest request = new HttpGet(SERVICE_URL);

        final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
