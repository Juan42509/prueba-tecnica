package com.playlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playlist.entity.ListaReproduccion;

public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Long>{
	Optional<ListaReproduccion> findByNombre(String nombre);
}
