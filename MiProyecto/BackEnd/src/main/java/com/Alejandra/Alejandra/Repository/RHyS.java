
package com.Alejandra.Alejandra.Repository;

import com.Alejandra.Alejandra.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Casa
 */
public interface RHyS extends JpaRepository<HyS, Integer>{
    Optional <HyS> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
