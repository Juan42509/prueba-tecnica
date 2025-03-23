import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; // Importación necesaria

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthInterceptorProviders } from './services/auth.interceptor';
import { ListasReproduccionComponent } from './admin/listas-reproduccion/listas-reproduccion.component';
import { ListasReproduccionCreacionComponent } from './admin/listas-reproduccion-creacion/listas-reproduccion-creacion.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListasReproduccionComponent,
    ListasReproduccionCreacionComponent
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
