package com.daw.inmobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daw.inmobiliaria.modelos.Agente;
import com.daw.inmobiliaria.modelos.Inmueble;
import com.daw.inmobiliaria.modelos.Venta;
import com.daw.inmobiliaria.repositorios.AgenteRepositorio;
import com.daw.inmobiliaria.repositorios.InmuebleRepositorio;
import com.daw.inmobiliaria.repositorios.VentaRepositorio;

@SpringBootApplication
public class InmobiliariaApplication implements CommandLineRunner {

	@Autowired
	private AgenteRepositorio ar;
	
	@Autowired
	private InmuebleRepositorio ir;
	
	@Autowired
	private VentaRepositorio vr;
	
	public static void main(String[] args) {
		SpringApplication.run(InmobiliariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Agente a1 = new Agente();
		a1.setApellidos("García");
		a1.setEmail("ff@gmail.com");
		a1.setNombre("Manuel");
		a1.setTelefono("3333333");
		ar.save(a1);
		
		Inmueble i1 = new Inmueble("Casa en Vera Playa", "Calle Principal 1", "Vera", 200, 4, 250000, LocalDate.now());
		ir.save(i1);
		
		Inmueble i2 = new Inmueble("Casa en Cuevas", "Calle Principal 1", "Vera", 150, 3, 270000, LocalDate.now());
		ir.save(i2);
		
		Venta v1 = new Venta(100000, LocalDate.now(), "45454545F", i1, a1);
		Venta v2 = new Venta(120000, LocalDate.now(), "45454545F", i2, a1);
		vr.save(v1);
		vr.save(v2);
		
		System.out.println(vr.findByFechaVentaAfter(LocalDate.now().minusDays(1)));

		

	}

}
