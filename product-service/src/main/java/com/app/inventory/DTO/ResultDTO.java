package com.app.inventory.DTO;

import com.app.inventory.utils.DTOUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ResultDTO extends DTOUtil{

	String name;
	
	String message;
	
	String description;
	
	public ResultDTO() {
		super();
		this.setCode(1);
		this.setType(this.getClass().toString());
	}
	
}
