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

import com.app.inventory.services.JobTitleService;
import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;

@RestController
@RequestMapping(value="jobTitle")
public class JobTitleRest {
		
	@Autowired
	private JobTitleService service;
	
	@GetMapping
	public List<JobTitle> getAllNamesJobTitle(){
		return service.getAllJobTitles();
	}
	
	@GetMapping(value="/users/{id}")
	public List<User> getUserByJobTitleID(@PathVariable Integer id){
		return service.getUserByJobTitlesID(id);
	}
	
	@GetMapping(value="/{id}")
	public JobTitle getJobTitleById(@PathVariable Integer id){
		System.out.println("aaa");
		return service.getJobTitleById(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteJobTitleById(@PathVariable Integer id){
		service.deleteJobTitleById(id);
	}
	
	@PostMapping
	public void createJobTitle(@RequestBody JobTitle job){
		service.createJobTitle(job);
	}
	
	@PostMapping(value="/update")
	public void updateJobTitle(@RequestBody JobTitle job){
		service.updateJobTitle(job);
	}

}
