package com.playlist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El Titulo es obligatorio")
	@NotNull
	private String titulo;
	
	@NotBlank(message = "El artista es obligatorio")
	@NotNull
	private String artista;
	
	@NotBlank(message = "El album es obligatorio")
	@NotNull
	private String album;
	
	@NotNull(message = "El anio es obligatorio")
	private int anno;
	
	@NotBlank(message = "El genero es obligatorio")
	@NotNull
	private String genero;
	
	@ManyToOne
    @JoinColumn(name = "lista_id")
	@JsonIgnore
    private ListaReproduccion listaReproduccion;
	
	public Cancion() {
		// TODO Auto-generated constructor stub
	}

	public Cancion(Long id, String titulo, String artista, String album, int anno, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.anno = anno;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ListaReproduccion getListaReproduccion() {
		return listaReproduccion;
	}

	public void setListaReproduccion(ListaReproduccion listaReproduccion) {
		this.listaReproduccion = listaReproduccion;
	}
	
	
	
}
