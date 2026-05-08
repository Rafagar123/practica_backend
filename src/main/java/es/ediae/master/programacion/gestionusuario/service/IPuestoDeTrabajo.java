package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.service.models.PuestoDeTrabajoModel;

public interface IPuestoDeTrabajo {

    List<PuestoDeTrabajoModel> obtenerTodosPuestos(String nickUsuario, String contrasena);

}
