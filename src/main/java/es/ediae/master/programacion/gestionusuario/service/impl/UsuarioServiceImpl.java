package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;
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

    @Autowired 
    private DireccionServiceImpl direccionServiceImpl;

    @Override
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);
        return usuario.isPresent();
    }

    @Override
    public List<UsuarioModel> obtenerTodosUsuarios(String nickUsuario, String contrasena) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return usuarioRepository.findAll().stream()
                    .map(UsuarioModel::fromEntity)
                    .toList();
        } else {
            return null;
        }

    }

    @Override
    public UsuarioModel usuarioPorId(Integer id, String nickUsuario, String contrasena) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return usuarioRepository.findById(id)
                    .map(UsuarioModel::fromEntity)
                    .orElse(null);
        } else {
            return null;
        }

    }

    @Override
    public boolean eliminarUsuario(Integer id, String nickUsuario, String contrasena) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            if (usuarioRepository.existsById(id)) {
                direccionServiceImpl.eliminarDireccionPorUsuarioId(id);
                usuarioRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario, String nickUsuario,
            String contrasena) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuarioOpt.isPresent() == true) {

            UsuarioEntity usuarioAnterior = usuarioRepository.findById(id).orElse(null);
            UsuarioEntity usuarioMismoNick = usuarioRepository.findByNickUsuario(usuario.getNickUsuario());
            if (usuarioMismoNick == null || usuarioMismoNick.getId().equals(id)) {
                usuarioAnterior.setNickUsuario(usuario.getNickUsuario());
                usuarioAnterior.setContrasena(usuario.getContrasena());
                usuarioAnterior.setFechaNacimiento(usuario.getFechaNacimiento());
                usuarioAnterior.setGenero(GeneroModel.toEntity(usuario.getGeneroModel()));
                usuarioAnterior.setNombre(usuario.getNombre());
                usuarioAnterior.setPrimerApellido(usuario.getPrimerApellido());
                usuarioAnterior.setSegundoApellido(usuario.getSegundoApellido());
                usuarioAnterior.setFechaNacimiento(usuario.getFechaNacimiento());
                usuarioAnterior.setHoraDesayuno(usuario.getHoraDesayuno());
                usuarioAnterior.setPuestoDeTrabajo(PuestoDeTrabajoModel.toEntity(usuario.getPuestoDeTrabajoModel()));
                usuarioAnterior.setEsAdmin(usuario.getEsAdmin());

                return UsuarioModel.fromEntity(usuarioRepository.save(usuarioAnterior));
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    /*
     * Método actualizarUsuario sin control sobre nickUsuario
     * 
     * @Override
     * public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario) {
     * return usuarioRepository.findById(id)
     * .map(existingUsuario -> {
     * existingUsuario.setNickUsuario(usuario.getNickUsuario());
     * existingUsuario.setContrasena(usuario.getContrasena());
     * existingUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
     * existingUsuario.setGenero(GeneroModel.toEntity(usuario.getGeneroModel()));
     * existingUsuario.setNombre(usuario.getNombre());
     * existingUsuario.setPrimerApellido(usuario.getPrimerApellido());
     * existingUsuario.setSegundoApellido(usuario.getSegundoApellido());
     * existingUsuario.setFechaNacimiento(usuario.getFechaNacimiento());
     * existingUsuario.setHoraDesayuno(usuario.getHoraDesayuno());
     * existingUsuario
     * .setPuestoDeTrabajo(PuestoDeTrabajoModel.toEntity(usuario.
     * getPuestoDeTrabajoModel()));
     * existingUsuario.setEsAdmin(usuario.getEsAdmin());
     * return UsuarioModel.fromEntity(usuarioRepository.save(existingUsuario));
     * })
     * .orElse(null);
     * }
     */

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuarioModel, String nickUsuario,
            String contrasena) {

        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuarioOpt.isPresent() == true) {

            UsuarioEntity usuarioEntity = new UsuarioEntity();
            LocalDateTime fechaHoraCreacion = LocalDateTime.now();

            if (usuarioRepository.findByNickUsuario(usuarioModel.getNickUsuario()) == null) {
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
                usuarioEntity.setEsAdmin(usuarioModel.getEsAdmin());
                return UsuarioModel.fromEntity(usuarioRepository.save(usuarioEntity));
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    /*
     * Método crearUsuario sin control sobre nickUsuario
     * 
     * @Override
     * public UsuarioModel crearUsuario(UsuarioModel usuarioModel) {
     * UsuarioEntity usuarioEntity = new UsuarioEntity();
     * LocalDateTime fechaHoraCreacion = LocalDateTime.now();
     * 
     * usuarioEntity.setNickUsuario(usuarioModel.getNickUsuario());
     * usuarioEntity.setContrasena(usuarioModel.getContrasena());
     * usuarioEntity.setFechaHoraCreacion(fechaHoraCreacion);
     * usuarioEntity.setGenero(GeneroModel.toEntity(usuarioModel.getGeneroModel()));
     * usuarioEntity.setNombre(usuarioModel.getNombre());
     * usuarioEntity.setPrimerApellido(usuarioModel.getPrimerApellido());
     * usuarioEntity.setSegundoApellido(usuarioModel.getSegundoApellido());
     * usuarioEntity.setFechaNacimiento(usuarioModel.getFechaNacimiento());
     * usuarioEntity.setHoraDesayuno(usuarioModel.getHoraDesayuno());
     * usuarioEntity.setPuestoDeTrabajo(PuestoDeTrabajoModel.toEntity(usuarioModel.
     * getPuestoDeTrabajoModel()));
     * usuarioEntity.setEsAdmin(usuarioModel.getEsAdmin());
     * return UsuarioModel.fromEntity(usuarioRepository.save(usuarioEntity));
     * }
     * 
     */

}
