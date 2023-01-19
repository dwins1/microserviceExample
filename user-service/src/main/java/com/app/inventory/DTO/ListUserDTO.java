package com.app.inventory.DTO;

import java.util.List;

import com.app.inventory.models.User;
import com.app.inventory.utils.DTOUtil;

import lombok.Data;

@Data
public class ListUserDTO extends DTOUtil{

	private List<User> listOfUser;
	
	public ListUserDTO() {
		super();
		this.setCode(10);
		this.setType(this.getClass().toString());
	}
	
	public ListUserDTO(List<User> list) {
		super();
		this.setCode(10);
		this.setType(this.getClass().toString());
		this.setListOfUser(list);
	}
	
}
