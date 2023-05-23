package com.daw.inmobiliaria;

import java.time.LocalDate;

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

import jakarta.transaction.Transactional;

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
	@Transactional
	public void run(String... args) throws Exception {
		
		Agente a1 = new Agente("Manuel", "García", "mg@gmail.com", "445455988");
		ar.save(a1);
		
		Inmueble i1 = new Inmueble("Casa en Vera Playa", "Calle Principal 1", "Vera", 200, 4, 250000, LocalDate.now());
		ir.save(i1);
		
		Inmueble i2 = new Inmueble("Casa en Cuevas", "Calle Principal 1", "Vera", 150, 3, 270000, LocalDate.now());
		ir.save(i2);
		
		Venta v1 = new Venta(100000, LocalDate.now(), "45454545F", i1, a1);
		Venta v2 = new Venta(120000, LocalDate.now(), "45454545F", i2, a1);
		vr.save(v1);
		vr.save(v2);
		
		vr.findById(1l).stream().forEach(System.out::println);
		vr.findByPrecioVentaGreaterThanEqual(10000).stream().forEach(System.out::println);
		vr.findByPrecioVentaBetween(110000, 121000).stream().forEach(System.out::println);
		
		//Si os fijáis hace un join de venta e inmueble
		vr.findByInmuebleCiudad("Vera").stream().forEach(System.out::println); 

	}

}
