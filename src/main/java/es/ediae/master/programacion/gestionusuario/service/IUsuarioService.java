package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

public interface IUsuarioService {

    boolean iniciarSesion(String nickUsuario, String contrasena);

    List<UsuarioModel> obtenerTodosUsuarios(String nickUsuario, String contrasena);

    UsuarioModel usuarioPorId(Integer id, String nickUsuario, String contrasena);

    boolean eliminarUsuario(Integer id, String nickUsuario, String contrasena);

    UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario, String nickUsuario, String contrasena);

    UsuarioModel crearUsuario(UsuarioModel usuario, String nickUsuario, String contrasena);

}
