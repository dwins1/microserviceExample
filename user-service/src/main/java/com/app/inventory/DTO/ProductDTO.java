package com.app.inventory.DTO;

import com.app.inventory.feignmodels.Elaboration;
import com.app.inventory.feignmodels.StateProduct;
import com.app.inventory.feignmodels.UbicationProduct;
import com.app.inventory.utils.DTOUtil;

import lombok.Data;
import lombok.NoArgsConstructor;


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
}
