package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
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
    public List<DireccionModel> buscarPorUsuarioId(Integer usuarioId) {
        return direccionRepository.buscarPorUsuarioId(usuarioId).stream()
                .map(DireccionModel::fromEntity)
                .toList();
    }

    @Override
    public List<DireccionModel> obtenerTodasDirecciones() {
        return direccionRepository.findAll().stream()
                .map(DireccionModel::fromEntity)
                .toList();
    }

    @Override
    public DireccionModel direccionPorId(Integer id) {
        return direccionRepository.findById(id)
                .map(DireccionModel::fromEntity)
                .orElse(null);
    }

    @Override
    public boolean eliminarDireccion(Integer id) {
        if (direccionRepository.existsById(id)) {
            direccionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Deberia actualizar tambien el usuario? Y de ser asi, lo hago con un objeto
    // usuario, o tiro de Id?
    @Override
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion) {
        return direccionRepository.findById(id)
                .map(existingDireccion -> {
                    existingDireccion.setNombreCalle(direccion.getNombreCalle());
                    existingDireccion.setNumeroCalle(direccion.getNumeroCalle());
                    existingDireccion.setDireccionPrincipal(direccion.getDireccionPrincipal());
                    return DireccionModel.fromEntity(direccionRepository.save(existingDireccion));
                })
                .orElse(null);
    }

    // Deberia meter el usuario por Id?
    @Override
    public DireccionModel crearDireccion(Integer usuarioId, DireccionModel direccion) {

        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        DireccionEntity direccionEntity = new DireccionEntity();
        direccionEntity.setNombreCalle(direccion.getNombreCalle());
        direccionEntity.setNumeroCalle(direccion.getNumeroCalle());
        direccionEntity.setDireccionPrincipal(direccion.getDireccionPrincipal());
        direccionEntity.setUsuario(usuario);

        return DireccionModel.fromEntity(direccionRepository.save(direccionEntity));
    }
}