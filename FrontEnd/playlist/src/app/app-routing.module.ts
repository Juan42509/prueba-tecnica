import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { ListasReproduccionComponent } from './home/listas-reproduccion/listar/listas-reproduccion.component';
import { AdminGuard } from './guards/admin.guard';
import { ListasReproduccionCreacionComponent } from './home/listas-reproduccion/crear/listas-reproduccion-creacion.component';
import { AgregarCancionComponent } from './home/listas-reproduccion/agregar_cancion/agregar-cancion/agregar-cancion.component';
import { PlaylistComponent } from './home/listas-reproduccion/verPlaylist/playlist/playlist.component';
import { NormalGuard } from './guards/normal.guard';

const routes: Routes = [
  {
    path:'',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'home',
    component:ListasReproduccionComponent,
    canActivate:[NormalGuard]
  },
  {
    path:'home/add-list',
    component:ListasReproduccionCreacionComponent,
    canActivate:[AdminGuard]
  },
  {
    path:'home/add-song/:IdLista',
    component:AgregarCancionComponent,
    canActivate:[NormalGuard]
  },
  {
    path:'home/view-list/:nameList',
    component:PlaylistComponent,
    canActivate:[NormalGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
