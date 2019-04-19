package ar.com.trimix.backendtest.persistence.service;

import java.util.List;

import ar.com.trimix.backendtest.persistence.dao.common.IOperations;
import ar.com.trimix.backendtest.persistence.model.Persona;

public interface IPersonaService extends IOperations<Persona> {
    
	 List<Persona> findByFilter(Persona personaFilter);
}
