package com.playlist.app;

import com.playlist.entity.ListaReproduccion;
import com.playlist.repository.ListaReproduccionRepository;
import com.playlist.service.ListaReproduccionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ListaReproduccionServiceTest {

    @Mock
    private ListaReproduccionRepository listaRepo;

    @InjectMocks
    private ListaReproduccionService listaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearLista() {
        ListaReproduccion lista = new ListaReproduccion("Lista Rock", "Lista de Rock Clásico");

        when(listaRepo.save(any(ListaReproduccion.class))).thenReturn(lista);

        ListaReproduccion creada = listaService.crearLista(lista);

        assertNotNull(creada);
        assertEquals("Lista Rock", creada.getNombre());
        assertEquals("Lista de Rock Clásico", creada.getDescripcion());
    }

    @Test
    void testObtenerListaPorNombre() {
        ListaReproduccion lista = new ListaReproduccion("Lista Pop", "Lista de Pop Clásico");

        when(listaRepo.findByNombre("Lista Pop")).thenReturn(Optional.of(lista));

        Optional<ListaReproduccion> encontrada = listaService.obtenerListaPorNombre("Lista Pop");

        assertTrue(encontrada.isPresent());
        assertEquals("Lista Pop", encontrada.get().getNombre());
    }

    @Test
    void testEliminarLista_Existente() {
        ListaReproduccion lista = new ListaReproduccion("Lista Jazz", "Lista de Jazz Clásico");

        when(listaRepo.findByNombre("Lista Jazz")).thenReturn(Optional.of(lista));
        doNothing().when(listaRepo).delete(lista);

        boolean eliminada = listaService.eliminarLista("Lista Jazz");

        assertTrue(eliminada);
        verify(listaRepo, times(1)).delete(lista);
    }

    @Test
    void testEliminarLista_NoExistente() {
        when(listaRepo.findByNombre("Lista Inexistente")).thenReturn(Optional.empty());

        boolean eliminada = listaService.eliminarLista("Lista Inexistente");

        assertFalse(eliminada);
    }
}
