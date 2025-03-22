package com.playlist.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "Lista_reproduccion")
public class ListaReproduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@NotBlank(message = "La descripcion es obligatoria")
	@NotNull
	private String descripcion;
	
	@OneToMany(mappedBy = "listaReproduccion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones = new ArrayList<>();
	
	public ListaReproduccion() {
		// TODO Auto-generated constructor stub
	}

	public ListaReproduccion( @NotBlank(message = "El nombre es obligatorio") @NotNull String nombre,
			@NotBlank(message = "La descripcion es obligatoria") @NotNull String descripcion, List<Cancion> canciones) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.canciones = canciones;
	}
	
	

	public ListaReproduccion(@NotBlank(message = "El nombre es obligatorio") @NotNull String nombre,
			@NotBlank(message = "La descripcion es obligatoria") @NotNull String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
	
	
}
