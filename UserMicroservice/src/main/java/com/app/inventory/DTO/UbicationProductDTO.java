package com.app.inventory.DTO;


import java.util.List;

import com.app.inventory.feignmodels.Product;
import com.app.inventory.utils.DTOUtil;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UbicationProductDTO extends DTOUtil {
	

	private Integer id;

	private String ubication; 
	
	private List<Product> products;
	
	public UbicationProductDTO() {
		super();
		this.setCode(4);
		this.setType(this.getClass().toString());
	}
}
