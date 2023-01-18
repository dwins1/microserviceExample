package com.app.inventory.repository;



import java.util.List;

import com.app.inventory.models.Elaboration;
import com.app.inventory.models.UbicationProduct;



public interface UbicationRepository{
	
	List<UbicationProduct> getAllUbication();
	
	UbicationProduct getUbicationById(Integer id);
	
	void deleteUbicationById(Integer id);
	
	void createUbication(UbicationProduct ubication);
	
	void updateUbication(UbicationProduct ubication);
	
}
