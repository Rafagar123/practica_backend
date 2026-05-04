package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;
import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<DireccionModel> buscarPorUsuarioId(Integer usuarioId) {
        return direccionRepository.buscarPorUsuarioId(usuarioId).stream()
                .map(DireccionModel::fromEntity)
                .toList();
    }

    @Override
    public DireccionModel direccionPorId(Integer id) {
        return direccionRepository.findById(id)
                .map(DireccionModel::fromEntity)
                .orElse(null);
    }
}
