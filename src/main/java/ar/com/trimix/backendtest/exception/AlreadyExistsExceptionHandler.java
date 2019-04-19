package ar.com.trimix.backendtest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AlreadyExistsExceptionHandler implements ExceptionMapper<PersonaAlreadyExists> {
    public Response toResponse(PersonaAlreadyExists ex) {
        return Response.status(Response.Status.CONFLICT.getStatusCode()).build();
    }
}
