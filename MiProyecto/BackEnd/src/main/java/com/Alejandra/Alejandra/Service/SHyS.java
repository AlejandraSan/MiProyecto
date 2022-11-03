
package com.Alejandra.Alejandra.Service;

import com.Alejandra.Alejandra.Entity.HyS;
import com.Alejandra.Alejandra.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Casa
 */
@Transactional  //para que haya persistencia de datos en front y back
@Service
public class SHyS {
    @Autowired
    RHyS rhys;
    
    public List<HyS> list(){
        return rhys.findAll(); //buscar todos
    }
    
    public Optional<HyS> getOne(int id){
        return rhys.findById(id); //buscar por id
    }
    
    public Optional<HyS> getByNombre(String nombre){
        return rhys.findByNombre(nombre); // buscar por nombre
    }
    
    public void save(HyS skill){
        rhys.save(skill); //guardar un archivo 
    }
    
    public void delete(int id){
        rhys.deleteById(id);//busca un id  y lo elimina
    }
    
    public boolean existsById(int id){
        return rhys.existsById(id); //chequear si existe un id
    }
    
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre); // chequear si existe el nombre
    }
}
