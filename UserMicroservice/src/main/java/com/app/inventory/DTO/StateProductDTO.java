package com.app.inventory.DTO;


import java.util.List;

import com.app.inventory.feignmodels.Product;
import com.app.inventory.utils.DTOUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class StateProductDTO extends DTOUtil{
	

	private Integer id;

	private String state; 
	
	private List<Product> products;
	
	public StateProductDTO() {
		super();
		this.setCode(4);
		this.setType(this.getClass().toString());
	}
}
