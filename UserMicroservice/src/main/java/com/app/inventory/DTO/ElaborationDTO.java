package com.app.inventory.DTO;



import java.util.List;

import com.app.inventory.feignmodels.Product;
import com.app.inventory.utils.DTOUtil;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ElaborationDTO extends DTOUtil{
	
	private Integer id;
	
	private String typeOfElaboration;
	
	private List<Product> products;
	
	public ElaborationDTO() {
		super();
		this.setCode(2);
		this.setType(this.getClass().toString());
	}
}
