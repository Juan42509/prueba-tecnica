import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { ListasReproduccionComponent } from './home/listas-reproduccion/listar/listas-reproduccion.component';
import { AdminGuard } from './guards/admin.guard';
import { ListasReproduccionCreacionComponent } from './home/listas-reproduccion/crear/listas-reproduccion-creacion.component';
import { AgregarCancionComponent } from './home/listas-reproduccion/agregar_cancion/agregar-cancion/agregar-cancion.component';

const routes: Routes = [
  {
    path:'',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'home',
    component:ListasReproduccionComponent,
    pathMatch:'full'
  },
  {
    path:'home/add-list',
    component:ListasReproduccionCreacionComponent,
    canActivate:[AdminGuard]
  },
  {
    path:'home/add-song',
    component:AgregarCancionComponent,
    canActivate:[AdminGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
