package es.ediae.master.programacion.gestionusuario.repository;

import es.ediae.master.programacion.gestionusuario.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneroRepository extends JpaRepository<GeneroEntity, Integer> {
    
}
 