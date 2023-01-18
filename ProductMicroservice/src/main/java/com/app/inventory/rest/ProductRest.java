package com.app.inventory.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.services.ProductService;
import com.app.inventory.userms.User;
import com.app.inventory.utils.DTOUtil;
import com.app.inventory.utils.ExceptionUtil;
import com.app.inventory.DTO.ProductDTO;
import com.app.inventory.DTO.ResultDTO;
import com.app.inventory.models.Elaboration;
import com.app.inventory.models.Product;
import com.app.inventory.models.StateProduct;

@RestController
@RequestMapping(value="product")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductRest {
		
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping(value="/{id}")
	public Product getProductByID(@PathVariable Integer id){
		return service.getProductById(id);
	}
	/*
	@GetMapping(value="/filteredconsult")
	public List<Product> getProductByElaborationAndStateAndUbication(@RequestParam Integer idElaboration, @RequestParam Integer idState, @RequestParam Integer idUbication){
		
		if(idElaboration==0 && idState==0 && idUbication==0) {
			return service.getAllProduct();
		}
		else if(idElaboration!=0 && idState==0 && idUbication==0) {
			return service.getProductByElaboration(idElaboration);
		}
		else if(idElaboration!=0 && idState!=0 && idUbication==0) {
			return service.getProductByElaborationAndState(idElaboration, idState);
		}
		else if(idElaboration!=0 && idState!=0 && idUbication!=0) {
			return service.getProductByElaborationAndStateAndUbication(idElaboration, idState, idUbication);
		}
		else if(idElaboration==0 && idState!=0 && idUbication!=0) {
			return service.getProductByStateAndUbication(idState, idUbication);
		}
		else if(idElaboration!=0 && idState==0 && idUbication!=0) {
			return service.getProductByElaborationAndUbication(idElaboration, idUbication);
		}
		else if(idElaboration==0 && idState!=0 && idUbication==0) {
			return service.getProductByState(idState);
		}
		else if(idElaboration==0 && idState==0 && idUbication!=0) {
			return service.getProductByUbication(idUbication);
		}
		return null;
	}*/
	
	
	@DeleteMapping(value="/{id}")
	public void deleteProductById(@PathVariable Integer id){
		service.deleteProductById(id);
	}
	
	@PostMapping
	public ResponseEntity<DTOUtil> createProduct(@RequestBody ProductDTO productDTO){
		ResultDTO result=new ResultDTO();
		try {
		service.createProduct(new Product(productDTO));	
		result.setMessage("Creacion Exitosa");
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}
		catch (ExceptionUtil e) {
			result.setMessage(e.getMessage());
			result.setDescription(e.getDescription());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
		catch (Exception e) {
			result.setMessage("error interno al buscar la lista de usuarios");
			result.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	
	
	/*
	@PostMapping(value="/update")
	public List<Product> updateProduct(@RequestHeader(value="Authorization") String token, @RequestBody Product product){
		service.updateProduct(product);
		return service.getAllProduct();
	}*/
	
	@GetMapping(value="/user")
	public List<User> getAllUser(){
		System.out.println("aaaaaaaaaaaaaaaaaaa");
		return service.getAllUser();
	}
	
}
