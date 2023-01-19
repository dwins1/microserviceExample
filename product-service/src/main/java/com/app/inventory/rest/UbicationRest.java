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

import com.app.inventory.services.ElaborationService;
import com.app.inventory.services.UbicationService;
import com.app.inventory.models.Elaboration;
import com.app.inventory.models.UbicationProduct;



@RestController
@RequestMapping(value="ubication")
public class UbicationRest {
		
	@Autowired
	private UbicationService service;
	
	@GetMapping
	public List<UbicationProduct> getAllElaboration(){
		
		return service.getAllUbication();
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteUbicationById(@PathVariable Integer id){
		service.deleteUbicationById(id);
		
	}
	
	@GetMapping(value="/{id}")
	public UbicationProduct getUbicationById(@PathVariable Integer id){
		return service.getUbicationById(id);
	}
	
	@PostMapping
	public void createUbication(@RequestBody UbicationProduct ubication){
		service.createUbication(ubication);
	}
	
	@PostMapping(value="/update")
	public void updateElaboration(@RequestBody UbicationProduct ubication){
		System.out.println("aaa");
		service.updateUbication(ubication);
	}
}
