package ar.com.trimix.backendtest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<PersonaNotFound> {
    public Response toResponse(PersonaNotFound ex) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
