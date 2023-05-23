package com.daw.inmobiliaria.modelos;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private long precioVenta;
	
	@Column
	private LocalDate fechaVenta;
	
	@Column
	private String dniComprador;
	
	@OneToOne
    @JoinColumn(name = "inmueble_id")
	private Inmueble inmueble;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "agente_id", foreignKey = @ForeignKey(name="agente_venta_fk", value=ConstraintMode.CONSTRAINT))
	private Agente agente;

	public Venta(long precioVenta, LocalDate fechaVenta, String dniComprador, Inmueble inmueble, Agente agente) {
		super();
		this.precioVenta = precioVenta;
		this.fechaVenta = fechaVenta;
		this.dniComprador = dniComprador;
		this.inmueble = inmueble;
		this.agente = agente;
	}
	
	
	
}
