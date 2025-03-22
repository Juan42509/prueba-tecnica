package com.playlist.service;

import java.util.List;
import java.util.Optional;

import com.playlist.entity.Cancion;
import com.playlist.entity.ListaReproduccion;

public interface ListaReproduccionService {
	
	ListaReproduccion crearLista(ListaReproduccion lista);
	public List<ListaReproduccion> obtenerListas();
    public Optional<ListaReproduccion> obtenerListaPorNombre(String nombre);
    public Optional<Cancion> agregarCancion(Long listaId, Cancion cancion);
    public Boolean eliminarLista(String nombre);
}
