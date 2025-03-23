import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { ListasReproduccionComponent } from './admin/listas-reproduccion/listas-reproduccion.component';
import { AdminGuard } from './guards/admin.guard';
import { ListasReproduccionCreacionComponent } from './admin/listas-reproduccion-creacion/listas-reproduccion-creacion.component';

const routes: Routes = [
  {
    path:'',
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:'admin',
    component:ListasReproduccionComponent,
    canActivate:[AdminGuard],
    children:[
      {
        path:'add-list',
        component:ListasReproduccionCreacionComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
