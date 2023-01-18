package com.app.inventory.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionUtil extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int error;
	String message;
	String description;
	
	public ExceptionUtil(int error) {
        super();
        this.error = error;
    }
	
	public ExceptionUtil(int error, String message) {
        super();
        this.error = error;
        this.message=message;
    }
	
	public ExceptionUtil(int error, String message, String description) {
        super();
        this.error = error;
        this.message=message;
        this.description=description;
    }
}
