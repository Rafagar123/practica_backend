package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.exception.UsuarioNoEncontradoException;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;
import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<DireccionModel> buscarPorUsuarioId(Integer usuarioId, String nickUsuario, String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return direccionRepository.buscarPorUsuarioId(usuarioId).stream()
                    .map(DireccionModel::fromEntity)
                    .toList();
        } else {
            return null;
        }
    }

    @Override
    public List<DireccionModel> obtenerTodasDirecciones(String nickUsuario, String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return direccionRepository.findAll().stream()
                    .map(DireccionModel::fromEntity)
                    .toList();
        } else {
            return null;
        }
    }

    @Override
    public DireccionModel direccionPorId(Integer id, String nickUsuario, String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return direccionRepository.findById(id)
                    .map(DireccionModel::fromEntity)
                    .orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarDireccion(Integer id, String nickUsuario, String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            if (direccionRepository.existsById(id)) {
                direccionRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarDireccionPorUsuarioId(Integer usuarioId) {
        List<DireccionEntity> direcciones = direccionRepository.buscarPorUsuarioId(usuarioId);

        if (direcciones.isEmpty()) {
            return false;
        } else {
            direccionRepository.deleteAll(direcciones);
            return true;
        }
    }

    @Override
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion, String nickUsuario,
            String contrasena) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuario.isPresent() == true) {
            return direccionRepository.findById(id)
                    .map(existingDireccion -> {
                        existingDireccion.setNombreCalle(direccion.getNombreCalle());
                        existingDireccion.setNumeroCalle(direccion.getNumeroCalle());
                        existingDireccion.setDireccionPrincipal(direccion.getDireccionPrincipal());
                        return DireccionModel.fromEntity(direccionRepository.save(existingDireccion));
                    })
                    .orElse(null);
        } else {
            return null;
        }

    }

    @Override
    public DireccionModel crearDireccion(Integer usuarioId, DireccionModel direccion, String nickUsuario,
            String contrasena) {

        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByNickUsuarioAndContrasena(nickUsuario, contrasena);

        if (usuarioOpt.isPresent() == true) {
            UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new UsuarioNoEncontradoException());

            DireccionEntity direccionEntity = new DireccionEntity();
            direccionEntity.setNombreCalle(direccion.getNombreCalle());
            direccionEntity.setNumeroCalle(direccion.getNumeroCalle());
            direccionEntity.setDireccionPrincipal(direccion.getDireccionPrincipal());
            direccionEntity.setUsuario(usuario);

            return DireccionModel.fromEntity(direccionRepository.save(direccionEntity));
        } else {
            return null;
        }
    }

}