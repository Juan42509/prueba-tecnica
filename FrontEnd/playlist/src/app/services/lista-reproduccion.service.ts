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
}
