package com.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playlist.entity.Cancion;

public interface CancionRepository extends JpaRepository<Cancion, Long>{

}
