package com.app.inventory.feignmodels;



import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Elaboration {
	

	private Integer id;
	

	private String typeOfElaboration;
	
	
	private List<Product> products;
}
