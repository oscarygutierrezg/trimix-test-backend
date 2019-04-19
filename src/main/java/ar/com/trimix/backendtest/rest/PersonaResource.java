package ar.com.trimix.backendtest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.com.trimix.backendtest.persistence.model.Persona;
import ar.com.trimix.backendtest.persistence.service.IPersonaService;

@Path("/personas")
public class PersonaResource {

    @Autowired
    @Qualifier("personaService")
    private IPersonaService personaService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Persona> findAll() {
    	try {
        return personaService.findAll();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new ArrayList<Persona>();
    	}    	
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{nombre}/{tipoDocumento}")
    public List<Persona>  findByFilter(@PathParam("nombre") String nombre, @PathParam("tipoDocumento") String tipoDocumento) {
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setTipoDocumento(tipoDocumento);
    	return personaService.findByFilter(p);
    }


    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Persona findOne(@PathParam("id") int id) {
        return personaService.findOne(id);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response update(Persona persona) {
    	System.out.println("FechaNacimiento() "+persona.getFechaNacimiento());
        personaService.update(persona);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deletePersona(@PathParam("id") int id) {
        personaService.deleteById(id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response create(Persona persona, @Context UriInfo uriInfo) {
    	Persona p = new Persona();
    	p.setApellido(persona.getApellido());
    	p.setNombre(persona.getNombre());
    	p.setTipoDocumento(persona.getTipoDocumento());
    	p.setFechaNacimiento(persona.getFechaNacimiento());
    	p.setNumeroDocumento(persona.getNumeroDocumento());
        personaService.create(p);
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), persona.getId())).build();
    }
}
