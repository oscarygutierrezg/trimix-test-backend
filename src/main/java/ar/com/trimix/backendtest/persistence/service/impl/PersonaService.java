package ar.com.trimix.backendtest.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.trimix.backendtest.persistence.dao.IPersonaDao;
import ar.com.trimix.backendtest.persistence.dao.common.IOperations;
import ar.com.trimix.backendtest.persistence.model.Persona;
import ar.com.trimix.backendtest.persistence.service.IPersonaService;
import ar.com.trimix.backendtest.persistence.service.common.AbstractHibernateService;

@Service
public class PersonaService extends AbstractHibernateService<Persona> implements IPersonaService {

    @Autowired
    @Qualifier("personaHibernateDao")
    private IPersonaDao dao;

    public PersonaService() {
        super();
    }

    // API

    @Override
    protected IOperations<Persona> getDao() {
        return dao;
    }

	public List<Persona> findByFilter(Persona personaFilter) {
		return dao.findByFilter(personaFilter);
	}

}
