package com.app.inventory.DTO;

import com.app.inventory.userms.JobTitle;
import com.app.inventory.userms.User;
import com.app.inventory.userms.UserDetail;
import com.app.inventory.utils.DTOUtil;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO extends DTOUtil {

	
	private Integer id;
	
	private String user;
	
	private String password;
	
	private UserDetail userDetail;
	
	private JobTitle jobTitle;
	
	public UserDTO(){
		super();
		this.setCode(6);
		this.setType(this.getClass().toString());
	}
	public UserDTO(User user){
		super();
		this.setCode(6);
		this.setType(this.getClass().toString());
		
		this.setId(user.getId());
		this.setUser(user.getUser());
		this.setPassword(user.getPassword());
		this.setUserDetail(user.getUserDetail());
		this.setJobTitle(user.getJobTitle());
	}
	
}
