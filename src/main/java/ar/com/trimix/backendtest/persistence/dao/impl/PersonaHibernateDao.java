package ar.com.trimix.backendtest.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

import ar.com.trimix.backendtest.persistence.dao.IPersonaDao;
import ar.com.trimix.backendtest.persistence.dao.common.AbstractHibernateDao;
import ar.com.trimix.backendtest.persistence.model.Persona;

@Repository
public class PersonaHibernateDao extends AbstractHibernateDao<Persona> implements IPersonaDao {

	public PersonaHibernateDao() {
		super();
		setClazz(Persona.class);
	}

	public List<Persona> findByFilter(Persona personaFilter) {
		Preconditions.checkNotNull(personaFilter);
		Query query = getCurrentSession().createQuery("from "+clazz.getName()+" where nombre like concat('%',:paramName,'%') or tipo_documento = :paramTipoDocumento");
		query.setParameter("paramName", personaFilter.getNombre());
		query.setParameter("paramTipoDocumento", personaFilter.getTipoDocumento());
		return query.getResultList();
	}
}
