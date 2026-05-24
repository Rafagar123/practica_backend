package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajo;
import es.ediae.master.programacion.gestionusuario.service.models.PuestoDeTrabajoModel;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajo {

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<PuestoDeTrabajoModel> obtenerTodosPuestos(String nickUsuario, String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return puestoDeTrabajoRepository.findAll().stream()
                    .map(PuestoDeTrabajoModel::fromEntity)
                    .toList();
        } else {
            return null;
        }
    }
}
