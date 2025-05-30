package com.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playlist.entity.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long>{

}
