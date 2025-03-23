import { Component, OnInit } from '@angular/core';
import { ListaReproduccionService } from '../../../services/lista-reproduccion.service';
import { error } from 'console';

@Component({
  selector: 'app-listas-reproduccion',
  templateUrl: './listas-reproduccion.component.html',
  styleUrls: ['./listas-reproduccion.component.css']
})
export class ListasReproduccionComponent implements OnInit {
  isAdmin: boolean = false;
  listas:any = []

  constructor(private listaReproduccionService: ListaReproduccionService) { }


  ngOnInit(): void {
    // Extraer el usuario del localStorage
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    console.log(user);

    if(user.rol == "ROLE_ADMIN"){
      this.isAdmin = true;
    }

    this.listaReproduccionService.ObtenerListas().subscribe(
      (data:any) =>{
        this.listas = data;
        console.log(data);
      },(error) => {
        console.log(error);
        alert("Error al Obtener las listas")
      }
    )

  }

  eliminarLista(nombre_lista:any){
    this.listaReproduccionService.eliminarListaReproduccion(nombre_lista).subscribe(
      (data:any) =>{
        alert("Se ha eliminado la lista")
        window.location.reload();
      },(error)=>{
        console.log(error);
        alert("Error al eliminar la lista")

      }
    )
  }

}
