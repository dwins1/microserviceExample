package com.app.inventory.DTO;



import com.app.inventory.userms.User;



import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
public class UserDetailDTO {

	private Integer id;
	
	private String name;
	
	private String lastname;
	
	private String email;
	
	private User user;
	
}
