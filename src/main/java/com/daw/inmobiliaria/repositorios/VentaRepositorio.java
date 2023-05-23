package com.daw.inmobiliaria.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.inmobiliaria.modelos.Venta;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long>{

	 public List<Venta> findByFechaVentaAfter(LocalDate fecha);
	 public List<Venta> findByPrecioVentaGreaterThanEqual(double precio);
	 public List<Venta> findByPrecioVentaBetween(double precio1, double precio2);
}
