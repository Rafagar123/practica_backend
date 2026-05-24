package es.ediae.master.programacion.gestionusuario.controller.DTO;

import es.ediae.master.programacion.gestionusuario.service.models.PuestoDeTrabajoModel;

public class PuestoDeTrabajoDTO {

    private Integer id;

    private String nombre;

    public PuestoDeTrabajoDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PuestoDeTrabajoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static PuestoDeTrabajoDTO fromModel(PuestoDeTrabajoModel model) {
        return new PuestoDeTrabajoDTO(model.getId(), model.getNombre());
    }
}
