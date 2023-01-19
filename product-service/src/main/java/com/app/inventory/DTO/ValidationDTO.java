package com.app.inventory.DTO;



import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.app.inventory.models.Product;
import com.app.inventory.utils.DTOUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class ValidationDTO extends DTOUtil{
	
	private String classObject="";
	
	private List<OneValidationDTO> validations;
	
	public ValidationDTO(List<FieldError> errors) {
		super();
		this.setCode(20);
		this.setType(this.getClass().toString());
		
		if(this.validations==null) {
			validations=new ArrayList<OneValidationDTO>();
		}
		for(FieldError error : errors) {
			OneValidationDTO oneValidation=new OneValidationDTO(error.getField(), error.getDefaultMessage());
			this.validations.add(oneValidation);
			if(this.classObject.isEmpty()) {
				this.classObject=error.getObjectName();
			}
			
		}
		
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class OneValidationDTO{
	private String field;
	private String message;
}