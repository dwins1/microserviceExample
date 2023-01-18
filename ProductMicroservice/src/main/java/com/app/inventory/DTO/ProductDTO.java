package com.app.inventory.DTO;


import com.app.inventory.models.Elaboration;
import com.app.inventory.models.Product;
import com.app.inventory.models.StateProduct;
import com.app.inventory.models.UbicationProduct;
import com.app.inventory.utils.DTOUtil;

import lombok.Data;


@Data
public class ProductDTO extends DTOUtil{
	
	private Integer id;
	
	private String name;
	
	private Integer idUser;
	
	private Elaboration elaboration;
	
	private StateProduct state;
	
	private UbicationProduct ubication;
	
	public ProductDTO() {
		super();
		this.setCode(3);
		this.setType(this.getClass().toString());
	}
	public ProductDTO(Product product) {
		super();
		this.setCode(3);
		this.setType(this.getClass().toString());
		
		this.setId(product.getId());
		this.setName(product.getName());
		this.setIdUser(product.getIdUser());
		this.setElaboration(product.getElaboration());
		this.setState(product.getState());
		this.setUbication(product.getUbication());
	}
}
