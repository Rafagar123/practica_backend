package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

public interface IUsuarioService {
    List<UsuarioModel> obtenerTodosUsuarios();

    UsuarioModel usuarioPorId(Integer id);

    boolean eliminarUsuario(Integer id);

    /*
    UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario);

    UsuarioModel crearUsuario(UsuarioModel usuario);
     */
}
