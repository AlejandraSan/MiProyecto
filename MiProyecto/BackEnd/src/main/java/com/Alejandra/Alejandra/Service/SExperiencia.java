
package com.Alejandra.Alejandra.Service;

import com.Alejandra.Alejandra.Entity.Experiencia;
import com.Alejandra.Alejandra.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional  //mantiene la persistencia, lo que se tiene aquí se mantiene en la bd
public class SExperiencia {
    
     @Autowired
     RExperiencia rExperiencia;
     
     //arma la lista de experiencia
     public List<Experiencia> list(){
         return rExperiencia.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return rExperiencia.findById(id);
     }
     //buscar por nombre
     public Optional<Experiencia> getByNombreE(String nombreE){
         return rExperiencia.findByNombreE(nombreE);
     }
     
     public void save(Experiencia expe){
         rExperiencia.save(expe);
     }
     //busca por id y borra 
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     //busca si existe la experiencia por id
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     //busca si existe la experiencia por nombre
     public boolean existsByNombreE(String nombreE){
         return rExperiencia.existsByNombreE(nombreE);
     }
    
}
