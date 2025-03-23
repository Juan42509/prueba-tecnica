package com.playlist.app;

import com.playlist.entity.Cancion;
import com.playlist.entity.ListaReproduccion;
import com.playlist.repository.CancionRepository;
import com.playlist.repository.ListaReproduccionRepository;
import com.playlist.service.ListaReproduccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ListaReproduccionServiceTest {

    @Autowired
    private ListaReproduccionService listaService;

    @MockBean
    private ListaReproduccionRepository listaRepo;

    @MockBean
    private CancionRepository cancionRepo;

    @Test
    public void testCrearLista() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Mi Playlist");

        when(listaRepo.save(lista)).thenReturn(lista);

        ListaReproduccion resultado = listaService.crearLista(lista);

        assertNotNull(resultado);
        assertEquals("Mi Playlist", resultado.getNombre());
        verify(listaRepo, times(1)).save(lista);
    }

    @Test
    public void testObtenerListas() {
        ListaReproduccion lista1 = new ListaReproduccion();
        lista1.setNombre("Salsa");

        ListaReproduccion lista2 = new ListaReproduccion();
        lista2.setNombre("Merengue");

        when(listaRepo.findAll()).thenReturn(Arrays.asList(lista1, lista2));

        List<ListaReproduccion> listas = listaService.obtenerListas();

        assertEquals(2, listas.size());
        verify(listaRepo, times(1)).findAll();
    }

    @Test
    public void testObtenerListaPorNombre() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Rock");

        when(listaRepo.findByNombre("Rock")).thenReturn(Optional.of(lista));

        Optional<ListaReproduccion> resultado = listaService.obtenerListaPorNombre("Rock");

        assertTrue(resultado.isPresent());
        assertEquals("Rock", resultado.get().getNombre());
        verify(listaRepo, times(1)).findByNombre("Rock");
    }

    @Test
    public void testAgregarCancion() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setId(1L);
        lista.setNombre("Rock");

        Cancion cancion = new Cancion();
        cancion.setTitulo("Bohemian Rhapsody");

        when(listaRepo.findById(1L)).thenReturn(Optional.of(lista));
        when(cancionRepo.save(any(Cancion.class))).thenReturn(cancion);

        Optional<Cancion> resultado = listaService.agregarCancion(1L, cancion);

        assertTrue(resultado.isPresent());
        assertEquals("Bohemian Rhapsody", resultado.get().getTitulo());
        verify(listaRepo, times(1)).findById(1L);
        verify(cancionRepo, times(1)).save(cancion);
    }

    @Test
    public void testEliminarLista_Success() {
        ListaReproduccion lista = new ListaReproduccion();
        lista.setNombre("Vallenato");

        when(listaRepo.findByNombre("Vallenato")).thenReturn(Optional.of(lista));
        doNothing().when(listaRepo).delete(lista);

        Boolean resultado = listaService.eliminarLista("Vallenato");

        assertTrue(resultado);
        verify(listaRepo, times(1)).findByNombre("Vallenato");
        verify(listaRepo, times(1)).delete(lista);
    }

    @Test
    public void testEliminarLista_NotFound() {
        when(listaRepo.findByNombre("Inexistente")).thenReturn(Optional.empty());

        Boolean resultado = listaService.eliminarLista("Inexistente");

        assertFalse(resultado);
        verify(listaRepo, times(1)).findByNombre("Inexistente");
        verify(listaRepo, never()).delete(any());
    }
}
