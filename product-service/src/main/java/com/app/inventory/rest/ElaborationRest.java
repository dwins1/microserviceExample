package com.app.inventory.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.services.ElaborationService;
import com.app.inventory.utils.DTOUtil;
import com.app.inventory.DTO.ElaborationDTO;
import com.app.inventory.DTO.ResultDTO;
import com.app.inventory.DTO.ValidationDTO;
import com.app.inventory.models.Elaboration;



@RestController
@RequestMapping(value="elaboration")
public class ElaborationRest {
		
	@Autowired
	private ElaborationService service;
	
	@GetMapping
	public List<Elaboration> getAllElaboration(){
		
		return service.getAllElaboration();
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteElaborationById(@PathVariable Integer id){
		service.deleteElaborationById(id);
		
	}
	
	@GetMapping(value="/{id}")
	public Elaboration getElaborationById(@PathVariable Integer id){
		return service.getElaborationById(id);
	}
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping
	public ResponseEntity<DTOUtil> createElaboration(@Valid @RequestBody ElaborationDTO elaboration,
			BindingResult validResult){
		ResponseEntity result=null;
		
		if(!validResult.hasErrors()) {
		service.createElaboration(elaboration);
		System.out.println("objeto guardado exitosamente");
		ResultDTO resultDTO=new ResultDTO();
		return result.ok(resultDTO);
		}
		else {
			System.out.println("El objeto no se guardo");
			ValidationDTO validations= new ValidationDTO(validResult.getFieldErrors());
			return result.status(HttpStatus.BAD_REQUEST).body(validations);
		}
		/*
		System.out.println(validResult.hasErrors());
		System.out.println("");
		System.out.println(validResult.getAllErrors());
		System.out.println("");
		System.out.println(validResult.getFieldError());
		System.out.println("");
		System.out.println(validResult.toString());
		System.out.println("");
		System.out.println(validResult.getErrorCount());
		System.out.println("");
		System.out.println(validResult.getFieldError().getDefaultMessage());
		*/
	}
	
	@PostMapping(value="/update")
	public void updateElaboration(@RequestBody Elaboration elaboration){
		System.out.println("aaa");
		service.updateElaboration(elaboration);
	}
}
