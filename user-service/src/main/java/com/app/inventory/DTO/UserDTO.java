package com.app.inventory.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;
import com.app.inventory.models.UserDetail;
import com.app.inventory.utils.DTOUtil;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
