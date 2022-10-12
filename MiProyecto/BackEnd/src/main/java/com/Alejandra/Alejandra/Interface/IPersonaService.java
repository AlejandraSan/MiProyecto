/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
Interface del servicio de Persona  llama al servicio
 */
package com.Alejandra.Alejandra.Interface;

import com.Alejandra.Alejandra.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    
    //Eliminar un usuario(objeto) por Id
    public void deletePersona(Long id);
    
    
    //Buscar una persona por Id
    public Persona findPersona(Long id);
    
}
