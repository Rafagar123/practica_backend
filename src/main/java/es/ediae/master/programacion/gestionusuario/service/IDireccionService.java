package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

public interface IDireccionService {

    public List<DireccionModel> buscarPorUsuarioId(Integer usuarioId);
    public DireccionModel direccionPorId(Integer id);
}
