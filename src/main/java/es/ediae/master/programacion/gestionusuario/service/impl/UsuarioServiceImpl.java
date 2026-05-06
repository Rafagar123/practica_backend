package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import es.ediae.master.programacion.gestionusuario.service.models.GeneroModel;
import es.ediae.master.programacion.gestionusuario.service.models.PuestoDeTrabajoModel;
import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioModel::fromEntity)
                .toList();
    }

    @Override
    public UsuarioModel usuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioModel::fromEntity)
                .orElse(null);
    }

    @Override
    public boolean eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario) {
        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNickUsuario(usuario.getNickUsuario());
                    existingUsuario.setContrasena(usuario.getContrasena());
                    existingUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
                    existingUsuario.setGenero(GeneroModel.toEntity(usuario.getGeneroModel()));
                    existingUsuario.setNombre(usuario.getNombre());
                    existingUsuario.setPrimerApellido(usuario.getPrimerApellido());
                    existingUsuario.setSegundoApellido(usuario.getSegundoApellido());
                    existingUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
                    existingUsuario.setHoraDesayuno(usuario.getHoraDesayuno());
                    existingUsuario.setPuestoDeTrabajo(PuestoDeTrabajoModel.toEntity(usuario.getPuestoDeTrabajoModel()));
                    return UsuarioModel.fromEntity(usuarioRepository.save(existingUsuario));
                })
                .orElse(null);
    }

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuarioModel) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        LocalDateTime fechaHoraCreacion = LocalDateTime.now();

        usuarioEntity.setNickUsuario(usuarioModel.getNickUsuario());
        usuarioEntity.setContrasena(usuarioModel.getContrasena());
        usuarioEntity.setFechaHoraCreacion(fechaHoraCreacion);
        usuarioEntity.setGenero(GeneroModel.toEntity(usuarioModel.getGeneroModel()));
        usuarioEntity.setNombre(usuarioModel.getNombre());
        usuarioEntity.setPrimerApellido(usuarioModel.getPrimerApellido());
        usuarioEntity.setSegundoApellido(usuarioModel.getSegundoApellido());
        usuarioEntity.setFechaNacimiento(usuarioModel.getFechaNacimiento());
        usuarioEntity.setHoraDesayuno(usuarioModel.getHoraDesayuno());
        usuarioEntity.setPuestoDeTrabajo(PuestoDeTrabajoModel.toEntity(usuarioModel.getPuestoDeTrabajoModel()));
        return UsuarioModel.fromEntity(usuarioRepository.save(usuarioEntity));
    }

}
