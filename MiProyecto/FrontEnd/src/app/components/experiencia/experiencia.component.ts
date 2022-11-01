import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe : Experiencia[] = [];
  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  //validar si estamos logueados
  ngOnInit(): void {
    this.cargarExperiencia(); //carga la experiencia
    if(this.tokenService.getToken()){ //valida el token
      this.isLogged = true;

    }else{
    this.isLogged = false;
    }
  }


  cargarExperiencia():void{
    this.sExperiencia.lista().subscribe(data => { this.expe = data; })
  }

  delete(id?: number){
    if(id !=undefined){
      this.sExperiencia.delete(id).subscribe(
        data => {
          this.cargarExperiencia();  //refresca la pagina despues de eliminarlo
        }, err =>{
          alert("No se pudo borrar la experiencia");
        }
      )
    }

  }

}


