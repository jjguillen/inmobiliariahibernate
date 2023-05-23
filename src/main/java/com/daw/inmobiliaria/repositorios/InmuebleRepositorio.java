package com.daw.inmobiliaria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.inmobiliaria.modelos.Inmueble;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, Long>{

}
