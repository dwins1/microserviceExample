package com.app.inventory.DTO;



import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.app.inventory.models.Product;
import com.app.inventory.utils.DTOUtil;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class ElaborationDTO extends DTOUtil{
	
	
	private Integer id;
	
	@NotNull(message="No ha especificado el Tipo de Eleboración")
	@NotEmpty(message="El campo no debe ser vacio")
	private String typeOfElaboration;
	
	@Positive(message="el numero debe ser positivo")
	private int test1;
	
	@Range(min=10, max=20, message="El valor debe estar entre 10 y 20")
	private int test2;
	
	private List<Product> products;
	
	public ElaborationDTO() {
		super();
		this.setCode(2);
		this.setType(this.getClass().toString());
	}
}
