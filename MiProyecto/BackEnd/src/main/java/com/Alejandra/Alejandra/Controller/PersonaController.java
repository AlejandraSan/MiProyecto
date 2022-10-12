/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Es un controlador a traves de la notacion @RestController
 */
package com.Alejandra.Alejandra.Controller;

import com.Alejandra.Alejandra.Entity.Persona;
import com.Alejandra.Alejandra.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    //el controlador llama a la interfaz del servicio usando el @Autowired
    @Autowired IPersonaService ipersonaService;
   
    //@GetMapping trae de la base de datos al frontend
    @GetMapping("personas/traer")//ejecuta el metodo cuando voy al localhsot4200
    //el front diferencia dependiendo de la url el tipo de metodo a utilizar
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //pedir desde el frontend guardar en la BD
    //crear un usuario
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
       ipersonaService.savePersona(persona);
       return "La perosna fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
       ipersonaService.deletePersona(id);
       return " La persona fue eliminada correctamente";
    }
    //url:puerto/personas/editar/4(id)/nombre & apellido & img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               
                              @RequestParam("nombre") String nuevoNombre,
                              @RequestParam("apellido") String nuevoApellido,
                              @RequestParam("img") String nuevoImg ){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        
        persona.setApellido(nuevoApellido);
        
        persona.setImg(nuevoImg);
        
        //guardar el objeto persona  en el IPerosnaService que lo enviara a la Entidad
        ipersonaService.savePersona(persona);
        return persona;
        
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
            
    
}
