package com.app.inventory.userms;

import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
public class JobTitle {
	
	private Integer id;
	
	private String jobTitle;
	
	private List<User> users;

}
