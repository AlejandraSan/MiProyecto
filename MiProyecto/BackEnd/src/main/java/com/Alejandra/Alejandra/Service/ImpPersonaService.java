/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Implementacion de PersonaService
Se comporta como un servicio, traer de IPersonaService 
 */
package com.Alejandra.Alejandra.Service;

import com.Alejandra.Alejandra.Entity.Persona;
import com.Alejandra.Alejandra.Interface.IPersonaService;
import com.Alejandra.Alejandra.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    

    @Override
    /*Traer una lista de personas, creo una variable que contenga
    una lista de personas
    
    */
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
                  
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonaRepository.save(persona);
     
    }

    @Override
    public void deletePersona(Long id) {
      ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
