package com.app.inventory.feignmodels;


import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UbicationProduct {
	

	private Integer id;

	private String ubication; 
	
	private List<Product> products;
}
