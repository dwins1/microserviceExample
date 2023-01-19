package com.app.inventory.services;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.inventory.models.StateProduct;
import com.app.inventory.repository.StateProductRepository;


@Repository
@Transactional
public class StateProductService implements StateProductRepository{

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StateProduct> getAllStateProduct() {
		String query="FROM StateProduct";
		
		return entityManager.createQuery(query).getResultList();
		
	}

	@Override
	public StateProduct getStateProductById(Integer id) {
		return entityManager.find(StateProduct.class, id);
	}

	@Override
	public void deleteStateProductById(Integer id) {
		StateProduct state=entityManager.find(StateProduct.class, id);
		entityManager.remove(state);
	}

	@Override
	public void createStateProduct(StateProduct state) {
		entityManager.merge(state);
	}

	@Override
	public void updateStateProduct(StateProduct state) {
		entityManager.merge(state);
	}

	

	
}
