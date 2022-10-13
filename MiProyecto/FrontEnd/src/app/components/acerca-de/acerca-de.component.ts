import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","");


//el constructor llama al servicio PersonaService creado 
  constructor(public personaService: PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data})
  }

  /* suscribe conecta el observer con algunos eventos observables,
  es un metodo que escucha siempre que Observable haga un cambio, y ejecuta
  un codigo y provoca una respuesta
  lo que está en persona se guardará en data 
  
  Cuando cambia la condicion seguarda  en data , suscribe escucha a data,
  y lo pasa al service, y service lo pasa al backend*/

}
