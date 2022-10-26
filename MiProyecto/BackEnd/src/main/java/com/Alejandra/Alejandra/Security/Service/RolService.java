/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Alejandra.Alejandra.Security.Service;

import com.Alejandra.Alejandra.Security.Entity.Rol;
import com.Alejandra.Alejandra.Security.Enums.RolNombre;
import com.Alejandra.Alejandra.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
//tratar de mantener lo que tenemos aquí en este momento,con la bd
//los mismos que tenemos aquí, tendremos en la bd, persistencia
//si una operación falla,esta notacion hace un rollback   y que no impacte en la bd
//o que se mantenga en un estdo anterior, y que todo siga como estaba
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return irolRepository.findByRolNombre(rolNombre);
    }
    
    //metodo para guardar nombres
    public void save(Rol rol){
       irolRepository.save(rol);
    }
    
}
