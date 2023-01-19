package com.app.inventory.feignmodels;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Product {
	
	private Integer id;
	
	private String name;
	
	private Integer idUser;
	
	private Elaboration elaboration;
	
	private StateProduct state;
	
	private UbicationProduct ubication;
}
