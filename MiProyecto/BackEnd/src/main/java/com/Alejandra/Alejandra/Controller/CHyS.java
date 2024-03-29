package com.Alejandra.Alejandra.Controller;

import com.Alejandra.Alejandra.Dto.dtoHyS;
import com.Alejandra.Alejandra.Entity.HyS;
import com.Alejandra.Alejandra.Security.Controller.Mensaje;
import com.Alejandra.Alejandra.Service.SHyS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Casa
 */
@RestController
@CrossOrigin(origins = "https://alejandrafront-a3e88.web.app")
@RequestMapping("/skill")
public class CHyS {

    @Autowired
    SHyS shys;

    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list() { //trae una lista de lo que hay
        List<HyS> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")//traer los datos de un id elegido
    public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {//si el id no existe, que devuelva que no existe
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hYs = shys.getOne(id).get(); //obtener uno por id
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys.existsById(id)) { //si no existe, que devuelva que no existe
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {//chequea si el body está en blanco
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //si existe el nombre de la habilidad en el service SHyS
        if (shys.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        /**
         * se crea una entidad de tipo HyS y se le pasa por parametro el nombre
         * y el porcentaje, despues se va al service y se trae el metodo guardar
         * y se agrega el skill a la lista
         */
        HyS hYs = new HyS(dtohys.getNombre(), dtohys.getPorcentaje());
        shys.save(hYs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys) {
        //Validamos si existe el ID
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HyS hYs = shys.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje(dtohys.getPorcentaje());

        shys.save(hYs);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
