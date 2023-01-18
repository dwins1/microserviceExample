package com.app.inventory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.app.inventory.DTO.ProductDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productos", schema="public")
@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name ="id_user")
	private Integer idUser;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_elaboration")
	@NotFound(action = NotFoundAction.IGNORE)
	private Elaboration elaboration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_estado")
	@NotFound(action = NotFoundAction.IGNORE)
	private StateProduct state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_ubicacion")
	@NotFound(action = NotFoundAction.IGNORE)
	private UbicationProduct ubication;
	
	public Product(ProductDTO productDTO) {
		this.name=productDTO.getName();
		this.idUser=productDTO.getIdUser();
		this.elaboration=productDTO.getElaboration();
		this.state=productDTO.getState();
		this.ubication=productDTO.getUbication();
	}
}
