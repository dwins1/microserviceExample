package com.app.inventory.userms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class User {

	private Integer id;

	private String user;

	private String password;

	private UserDetail userDetail;

	private JobTitle jobTitle;
	
}
