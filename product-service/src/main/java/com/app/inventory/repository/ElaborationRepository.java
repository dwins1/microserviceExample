package com.app.inventory.repository;



import java.util.List;

import com.app.inventory.DTO.ElaborationDTO;
import com.app.inventory.models.Elaboration;



public interface ElaborationRepository{
	
	List<Elaboration> getAllElaboration();
	
	Elaboration getElaborationById(Integer id);
	
	void deleteElaborationById(Integer id);
	
	void createElaboration(ElaborationDTO elaboration);
	
	void updateElaboration(Elaboration elaboration);
	
}
