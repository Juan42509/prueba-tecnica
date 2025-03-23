import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Importación necesaria

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthInterceptorProviders } from './services/auth.interceptor';
import { ListasReproduccionComponent } from './home/listas-reproduccion/listar/listas-reproduccion.component';
import { ListasReproduccionCreacionComponent } from './home/listas-reproduccion/crear/listas-reproduccion-creacion.component';
import { ListaRepodiccionEliminarComponent } from './home/listas-reproduccion/eliminar/lista-repodiccion-eliminar/lista-repodiccion-eliminar.component';
import { AgregarCancionComponent } from './home/listas-reproduccion/agregar_cancion/agregar-cancion/agregar-cancion.component';
import { PlaylistComponent } from './home/listas-reproduccion/verPlaylist/playlist/playlist.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListasReproduccionComponent,
    ListasReproduccionCreacionComponent,
    ListaRepodiccionEliminarComponent,
    AgregarCancionComponent,
    PlaylistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
