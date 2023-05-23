package com.daw.inmobiliaria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.inmobiliaria.modelos.Agente;

@Repository
public interface AgenteRepositorio extends JpaRepository<Agente, Long>{

}
