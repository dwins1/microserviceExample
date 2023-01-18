package com.app.inventory.services;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.inventory.DTO.ElaborationDTO;
import com.app.inventory.models.Elaboration;
import com.app.inventory.repository.ElaborationRepository;



@Repository
@Transactional
public class ElaborationService implements ElaborationRepository{

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Elaboration> getAllElaboration() {
		String query="FROM Elaboration";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public Elaboration getElaborationById(Integer id) {
		return entityManager.find(Elaboration.class, id);
	}

	@Override
	public void deleteElaborationById(Integer id) {
		Elaboration elaboration=entityManager.find(Elaboration.class, id);
		 entityManager.remove(elaboration);
	}

	@Override
	public void createElaboration(ElaborationDTO elaboration) {	
		Elaboration elaborationModel=new Elaboration(elaboration);
	    entityManager.merge(elaborationModel);
	}

	@Override
	public void updateElaboration(Elaboration elaboration) {
		entityManager.merge(elaboration);
	}

	

	
}
