package com.playlist.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.entity.Cancion;
import com.playlist.entity.ListaReproduccion;
import com.playlist.service.ListaReproduccionService;

@RestController
@RequestMapping("/lists")
@CrossOrigin("*")
public class ListaReproduccionController {
	
	@Autowired
    private ListaReproduccionService listaService;

    @PostMapping
    public ResponseEntity<ListaReproduccion> crearLista(@Valid @RequestBody ListaReproduccion lista) {
        ListaReproduccion nuevaLista = listaService.crearLista(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);
    }
    
    @PostMapping("/{listaId}/add-song")
    public ResponseEntity<?> agregarCancion(@Valid @PathVariable Long listaId, @RequestBody Cancion cancion) {
        Optional<Cancion> CancionList = listaService.agregarCancion(listaId, cancion);
        return ResponseEntity.ok(CancionList);
    }

    @GetMapping
    public List<ListaReproduccion> obtenerListas() {
        return listaService.obtenerListas();
    }

    @GetMapping("/{listName}")
    public ResponseEntity<Optional<ListaReproduccion>> obtenerListaByNombre(@PathVariable String listName) {
    	Optional<ListaReproduccion> lista = listaService.obtenerListaPorNombre(listName);
    	if(!lista.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
        return ResponseEntity.ok(listaService.obtenerListaPorNombre(listName));
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void> eliminarLista(@PathVariable String listName) {
    	
    	Optional<ListaReproduccion> lista = listaService.obtenerListaPorNombre(listName);
    	if(!lista.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	
        listaService.eliminarLista(listName);
        return ResponseEntity.noContent().build();
    }
    
    
}

