package com.app.inventory.loginjwt;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@NoArgsConstructor
@ToString
public class ResultUtil {
	
	
	private String status;
	
	private String token;
	
	private String user;
	

}
