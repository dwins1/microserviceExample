package com.app.inventory.repository;



import java.util.List;

import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;

public interface JobTitleRepository{
	
	List<JobTitle> getAllJobTitles();
	

	
	JobTitle getJobTitleById(Integer id);
	
	void deleteJobTitleById(Integer id);
	
	void createJobTitle(JobTitle jobTitle);
	
	void updateJobTitle(JobTitle jobTitle);

	List<String> getAllNamesJobTitles();



	List<User> getUserByJobTitlesID(Integer id);
	
}
