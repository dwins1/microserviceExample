package com.app.inventory.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.services.UserService;
import com.app.inventory.utils.DTOUtil;
import com.app.inventory.utils.ExceptionUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.app.inventory.DTO.ListUserDTO;
import com.app.inventory.DTO.ResultDTO;
import com.app.inventory.DTO.UserDTO;
import com.app.inventory.feignclients.ProductFeignClient;
import com.app.inventory.feignmodels.Product;
import com.app.inventory.loginjwt.ResultUtil;
import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;

@RestController
@RequestMapping(value="user")
public class UserRest {
		
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<DTOUtil> getAllUser(){
		
		try {
			ListUserDTO listUser=new ListUserDTO(service.getAllUser());
			return ResponseEntity.status(HttpStatus.OK).body(listUser);
		}
		catch (ExceptionUtil e) {
			ResultDTO result=new ResultDTO();
			result.setMessage(e.getMessage());
			result.setDescription(e.getDescription());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
		catch (Exception e) {
			ResultDTO result=new ResultDTO();
			result.setMessage("error interno al buscar la lista de usuarios");
			result.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping(value="/product")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping(value="/byjobtitle")
	public ResponseEntity<DTOUtil> getUserByJobTitle(@RequestBody JobTitle jobTitle){
		
		try {
			ListUserDTO listUser=new ListUserDTO(service.getUserByJobTitle(jobTitle));
			return ResponseEntity.status(HttpStatus.OK).body(listUser);
		} 
		catch (ExceptionUtil e) {
			ResultDTO result=new ResultDTO();
			result.setMessage(e.getMessage());
			result.setDescription(e.getDescription());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
		catch (Exception e) {
			ResultDTO result=new ResultDTO();
			result.setMessage("error interno al buscar la lista de usuarios");
			result.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<DTOUtil> getUserById(@PathVariable Integer id){
		try {
		UserDTO user= new UserDTO(service.getUserById(id));
		return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		catch (ExceptionUtil e) {
			ResultDTO result=new ResultDTO();
			result.setMessage(e.getMessage());
			result.setDescription(e.getDescription());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
		catch (Exception e) {
			// TODO: handle exception
			ResultDTO result=new ResultDTO();
			result.setMessage("Fallo al realizar a la consulta a la BD");
			result.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
			
		}
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteUserById(@PathVariable Integer id){
		try {
			service.deleteUserById(id);
		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (Exception e) {
			
		}
	}
	
	@PostMapping
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<DTOUtil> createUser(@RequestBody User user){
		ResultDTO result=new ResultDTO();
		try {
			service.createUser(user); 
			result.setMessage("Usuario creado con exito");
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
	
	@PostMapping(value="/update")
	public void updateUser(@RequestBody User user){
		try {
			service.updateUser(user);
		} catch (ExceptionUtil e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/getUserListByID")
	public List<User> getUserListByID(){
		return service.getUserListByID();
	}
	@PostMapping(value="/specialcase")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<DTOUtil> specialCase(@RequestBody Holder holder){
		User user = holder.getUser();
		Product product=holder.getProduct();
		Integer idUser;
		ResultDTO result=new ResultDTO();
		try {
			idUser=service.createUser(user);
			product.setIdUser(idUser);
			HttpStatus statusRequestProduct=service.createProduct(product).getStatusCode();
			if(statusRequestProduct==HttpStatus.CREATED) {
				result.setMessage("Usuario y producto creado con exito");
				return ResponseEntity.status(HttpStatus.CREATED).body(result);
			}
			else {
				service.deleteUserById(idUser);
				result.setMessage("Error al crear Usuario y producto");
				result.setDescription("No fue posible que crear el producto, revice: product-microservice");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
			}
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
	@PostMapping(value="/prueba")
	public void prueba(@RequestBody String string){
		
		System.out.println("String:");
		System.out.println(string);
		char[] myChars = string.toCharArray();
		
		for(int i=0; i<myChars.length;i++){
			
		if(Character.compare(myChars[i], ':')==0 || Character.compare(myChars[i], '{')==0  || Character.compare(myChars[i], '}')==0) {
			System.out.println("entro");
			myChars[i]=' ';
			
		}
		System.out.println(myChars[i]);
		}
		String string1=String.valueOf(myChars);
		JSONParser parser = new JSONParser();  
		System.out.println("String1:");
		System.out.println(string1);
		try {
			json = (JSONArray) parser.parse(string1);
			System.out.println(json);
			//Map<Object, List<Object>> valores =(Map<Object, List<Object>>) json.);
			//	System.out.println(valores);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		/*
		List<Object> aviso=new ArrayList();
		List<String> contenerdor= 
		"aviso": { 
			   "tipoDato": "numerico", 
			   "longitud": 10, 
			   "obligatorio": true 
			   }, 
		
		
	}
	
	@GetMapping(value="/test")
	public void prueba(@RequestBody String test){
		System.out.println(test);
	}
	*/
	
	
	
}
@Getter
@Setter
@NoArgsConstructor
class Holder{
	private User user;
	private Product product;
}


