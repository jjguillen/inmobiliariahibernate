package com.daw.inmobiliaria.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Agente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@OneToMany(mappedBy = "agente")	
	private List<Venta> ventasAgente;
	
	public void addVenta(Venta v) {
		ventasAgente.add(v);
		v.setAgente(this);
	}

	public Agente(String nombre, String apellidos, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.ventasAgente = new ArrayList<>();
	}

	public Agente() {
		super();
		this.ventasAgente = new ArrayList<>();
	}
	
	
	
	
	
}
