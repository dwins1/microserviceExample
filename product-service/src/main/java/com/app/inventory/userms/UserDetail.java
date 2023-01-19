package com.app.inventory.userms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDetail {

	private Integer id;
	
	private String name;
	
	private String lastname;
	
	private String email;
	
	private User user;
	
	
}
