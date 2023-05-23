package com.daw.inmobiliaria.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inmueble {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String ciudad;
	
	@Column
	private int superficie;
	
	@Column(columnDefinition = "TINYINT")
	private int habitaciones;
	
	@Column(columnDefinition = "BIGINT")
	private long precio;
	
	@Column
	@Temporal(TemporalType.DATE)
	private LocalDate fechaCreacion;
	
	@OneToOne
	@JoinColumn(name = "venta_id")
	private Venta venta;

	public Inmueble(String nombre, String direccion, String ciudad, int superficie, int habitaciones, long precio,
			LocalDate fechaCreacion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.superficie = superficie;
		this.habitaciones = habitaciones;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
}
