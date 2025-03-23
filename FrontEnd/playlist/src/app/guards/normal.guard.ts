import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NormalGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const usuario = JSON.parse(localStorage.getItem('user') || '{}');
    const token = localStorage.getItem('token') || '{}';

    if (usuario && usuario.rol && token) {
      return true; // Permite el acceso si el usuario tiene rol
    }

    this.router.navigate(['']); // Redirige al login si no está autenticado
    return false;
  }

}
