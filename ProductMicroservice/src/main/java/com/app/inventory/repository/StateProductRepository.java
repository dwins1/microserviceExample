package com.app.inventory.repository;



import java.util.List;

import com.app.inventory.models.StateProduct;



public interface StateProductRepository{
	
	List<StateProduct> getAllStateProduct();
	
	StateProduct getStateProductById(Integer id);
	
	void deleteStateProductById(Integer id);
	
	void createStateProduct(StateProduct state);
	
	void updateStateProduct(StateProduct state);
	
}
