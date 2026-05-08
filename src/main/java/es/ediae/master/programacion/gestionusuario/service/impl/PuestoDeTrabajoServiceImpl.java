package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

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

        UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return puestoDeTrabajoRepository.findAll().stream()
                    .map(PuestoDeTrabajoModel::fromEntity)
                    .toList();
        } else {
            return null;
        }

    }
}
