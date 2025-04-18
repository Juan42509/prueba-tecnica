import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();

  constructor(private http:HttpClient) { }

  // Generamos el token
  public genarateToken(loginData:any){
    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  //Iniciamos Sesion y establecemos el token en el localStorage
  public loginUser(token:any){
    localStorage.setItem('token',token)
    return false;
  }

  public isLoggedIn(){
    let tokenStr = localStorage.getItem('token')
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
      return false;
    }else{
      return true;
    }
  }

  //Cerramos sesion y eliminamos el token del localstorage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  //Obtener el token
  public getToken(){
    return localStorage.getItem('token');
  }

  public setUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));
  }

  public getUser(){
    let userStr = localStorage.getItem('user')
    if(userStr != null){
      return JSON.parse(userStr);
    }else{
      this.logout();
    }
  }

  public getUserRol(){
    let user = this.getUser();
    return user.rol;
  }

  public getCuerrentUser(){
    return this.http.get(`${baseUrl}/actual-usuario`);
  }


}
