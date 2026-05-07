package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

public interface IDireccionService {

    List<DireccionModel> buscarPorUsuarioId(Integer usuarioId, String nickUsuario, String contrasena);

    List<DireccionModel> obtenerTodasDirecciones(String nickUsuario, String contrasena);

    DireccionModel direccionPorId(Integer id, String nickUsuario, String contrasena);

    boolean eliminarDireccion(Integer id, String nickUsuario, String contrasena);

    DireccionModel actualizarDireccion(Integer id, DireccionModel direccion, String nickUsuario, String contrasena);

    DireccionModel crearDireccion(Integer usuarioId, DireccionModel direccion, String nickUsuario, String contrasena);
}
