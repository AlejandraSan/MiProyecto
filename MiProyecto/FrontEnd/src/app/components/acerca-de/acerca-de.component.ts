import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
 // persona: persona = new persona("","","","");
 persona: persona = null;


//el constructor llama al servicio PersonaService creado 
  constructor(
    public personaService: PersonaService,
    private tokenService: TokenService) { }
  isLogged = false;
  ngOnInit(): void {
   // this.personaService.getPersona().subscribe(data => {this.persona = data})
    this.cargarPersona();
    if(this.tokenService.getToken()){
      this.isLogged = true; //si obtiene el token, es = true
    } else {
      this.isLogged = false;
    }
 
  }

  cargarPersona(){
    this.personaService.detail(1).subscribe(data =>
      {this.persona = data}
      )
  }

  /* suscribe conecta el observer con algunos eventos observables,
  es un metodo que escucha siempre que Observable haga un cambio, y ejecuta
  un codigo y provoca una respuesta
  lo que está en persona se guardará en data 
  
  Cuando cambia la condicion seguarda  en data , suscribe escucha a data,
  y lo pasa al service, y service lo pasa al backend*/

}
