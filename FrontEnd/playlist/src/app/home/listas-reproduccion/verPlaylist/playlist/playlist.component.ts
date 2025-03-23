import { Component, OnInit } from '@angular/core';
import { ListaReproduccionService } from '../../../../services/lista-reproduccion.service';
import { ActivatedRoute } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  nombre_Lista: String  = '';
  canciones:any = [];

  constructor(private listaReproduccionService : ListaReproduccionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.nombre_Lista = String(this.route.snapshot.paramMap.get('nameList'));

    this.listaReproduccionService.obtenerListaByNombre(this.nombre_Lista).subscribe(
      (data:any)=>{
        this.canciones = data.canciones;
        console.log(data);
      },(error)=>{
        console.log(error);
        alert("Error al mostrar la PlayList");
      }
    )
  }



}
