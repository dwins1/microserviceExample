package com.app.inventory.feignmodels;


import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class StateProduct {
	

	private Integer id;
	

	private String state; 
	
	
	private List<Product> products;
}
