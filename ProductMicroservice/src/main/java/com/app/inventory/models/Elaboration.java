package com.app.inventory.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.inventory.DTO.ElaborationDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="elaboracion", schema="public")
@Getter
@Setter
@NoArgsConstructor
public class Elaboration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="tipo")
	private String typeOfElaboration;
	
	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy="elaboration", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Product> products;*/
	
	public Elaboration(ElaborationDTO eleboration) {
		this.setTypeOfElaboration(eleboration.getTypeOfElaboration());
		this.setId(eleboration.getId());
	}
	
}
