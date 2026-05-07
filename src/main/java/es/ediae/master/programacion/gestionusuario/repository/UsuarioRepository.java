package es.ediae.master.programacion.gestionusuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.*;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    List<UsuarioEntity> findByNickUsuario (String nickUsuario);

}
