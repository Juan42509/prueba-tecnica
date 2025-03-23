import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ListaReproduccionService {

  constructor(private http:HttpClient) { }

  public crearLista(lista:any){
    return this.http.post(`${baseUrl}/lists`, lista);
  }

  public ObtenerListas(){
    return this.http.get(`${baseUrl}/lists`);
  }

  public AgregarCancion(idLista:any , cancion:any){
    return this.http.post(`${baseUrl}/lists/${idLista}/add-song`,cancion);
  }

  public obtenerListaByNombre(Nombre_lista:any){
    return this.http.get(`${baseUrl}/lists/${Nombre_lista}`);
  }

  public eliminarListaReproduccion(Nombre_lista:any){
    return this.http.delete(`${baseUrl}/lists/${Nombre_lista}`);
  }
}
