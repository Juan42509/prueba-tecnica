import { Component, OnInit } from '@angular/core';
import { ListaReproduccionService } from '../../../../services/lista-reproduccion.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-agregar-cancion',
  templateUrl: './agregar-cancion.component.html',
  styleUrls: ['./agregar-cancion.component.css']
})
export class AgregarCancionComponent implements OnInit {

  idLista: number | null = null;

  cancion = {
    titulo:'',
    artista:'',
    album:'',
    anno:'',
    genero:''
  }

  constructor(private listaReproduccionService:ListaReproduccionService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.idLista = Number(this.route.snapshot.paramMap.get('IdLista'));
  }

  formSubmitCancion(){
    if(this.cancion.titulo.trim() == '' || this.cancion.artista == '' || this.cancion.album == '' || this.cancion.album == '' || this.cancion.anno == '' || this.cancion.genero == ''){
      alert("Todos los campos son obligatorios !!")
      return;
    }

    this.listaReproduccionService.AgregarCancion(this.idLista,this.cancion).subscribe(
      (data:any)=>{
        this.cancion.titulo = '';
        this.cancion.artista = '';
        this.cancion.album = '';
        this.cancion.anno = '';
        this.cancion.genero = '';

        alert("Cancion creada y agregada a la lista de reproduccion");
      },(error) =>{
        console.log(error);
        alert("Error al guardar la Cancion !!")
      }
    )
  }

}
