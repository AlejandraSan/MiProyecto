import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/';


  constructor(private http: HttpClient) { }

  /*Observable : el modulo http utiliza Observable para manejar 
  las peticiones y respuestas
  <persona> es el objeto
   
   */
  public getPersona(): Observable<persona>{
    return this.http.get<persona>(this.URL+'traer/perfil');
  }
}
