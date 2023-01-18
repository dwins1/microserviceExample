package com.app.inventory.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.inventory.services.StateProductService;
import com.app.inventory.models.StateProduct;

@RestController
@RequestMapping(value="stateproduct")
public class StateProductRest {
		
	@Autowired
	private StateProductService service;
	
	@GetMapping
	public List<StateProduct> getAllJobTitle(){
		
		return service.getAllStateProduct();
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteStateProductById(@PathVariable Integer id){
		service.deleteStateProductById(id);
	}
	
	@GetMapping(value="/{id}")
	public StateProduct getStateProductById(@PathVariable Integer id){
		return service.getStateProductById(id);
	}
	
	@PostMapping
	public void createJobTitle(@RequestBody StateProduct state){
		
		service.createStateProduct(state);
	}
	
	@PostMapping(value="/update")
	public void updateStateProduct(@RequestBody StateProduct state){
		
		service.updateStateProduct(state);
	}
}
