package com.playlist.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.entity.Cancion;
import com.playlist.entity.ListaReproduccion;
import com.playlist.repository.CancionRepository;
import com.playlist.repository.ListaReproduccionRepository;
import com.playlist.service.ListaReproduccionService;

@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService{
	
	@Autowired
	ListaReproduccionRepository listaRepo;
	
	@Autowired
    private CancionRepository cancionRepo;

	@Override
	public ListaReproduccion crearLista(ListaReproduccion lista) {
        return listaRepo.save(lista);
	}

	@Override
	public List<ListaReproduccion> obtenerListas() {
		return listaRepo.findAll();
	}

	@Override
	public Optional<ListaReproduccion> obtenerListaPorNombre(String nombre) {
		Optional<ListaReproduccion> listaReproOBJ = listaRepo.findByNombre(nombre);
		if(listaReproOBJ.isPresent()) {
			return listaReproOBJ;
		}
		
		return Optional.empty();
	}
	
	@Override
	public Optional<Cancion> agregarCancion(Long listaId, Cancion cancion) {
		Optional<ListaReproduccion> listaOpt = listaRepo.findById(listaId);
        if (listaOpt.isPresent()) {
            ListaReproduccion lista = listaOpt.get();
            cancion.setListaReproduccion(lista);
            return Optional.of(cancionRepo.save(cancion));
            
        }
        return Optional.empty();
	}

	@Override
	public void eliminarLista(String nombre) {
		Optional<ListaReproduccion> listaReproDel = listaRepo.findByNombre(nombre);
		listaReproDel.ifPresent(listaReproDb ->{
			listaRepo.delete(listaReproDb);
		});
		
	}



}
