package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

public interface IDireccionService {

    List<DireccionModel> buscarPorUsuarioId(Integer usuarioId);
    List<DireccionModel> obtenerTodasDirecciones();
    DireccionModel direccionPorId(Integer id);
    boolean eliminarDireccion(Integer id);
    DireccionModel actualizarDireccion(Integer id, DireccionModel direccion);
    DireccionModel crearDireccion(Integer usuarioId, DireccionModel direccion);
}
