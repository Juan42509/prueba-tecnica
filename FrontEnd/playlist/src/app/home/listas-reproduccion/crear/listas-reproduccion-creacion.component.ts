import { Component, OnInit } from '@angular/core';
import { ListaReproduccionService } from '../../../services/lista-reproduccion.service';

@Component({
  selector: 'app-listas-reproduccion-creacion',
  templateUrl: './listas-reproduccion-creacion.component.html',
  styleUrls: ['./listas-reproduccion-creacion.component.css']
})
export class ListasReproduccionCreacionComponent implements OnInit {

  lista={
    nombre:'',
    descripcion:''
  }

  constructor( private listaReproduccionService: ListaReproduccionService) { }

  ngOnInit(): void {
  }

  formSubmitList(){
    if(this.lista.nombre.trim() == '' || this.lista.descripcion == null){
      alert("El titulo es requerido !!")
      return;
    }

    this.listaReproduccionService.crearLista(this.lista).subscribe(
      (data:any) =>{
        this.lista.nombre = '';
        this.lista.descripcion = ''
        alert("Lista de Reproduccion creada");
      },(error) =>{
        console.log(error);
        alert("Error al guardar la Lista de Reproduccion !!")
      }
    )

  }


}
