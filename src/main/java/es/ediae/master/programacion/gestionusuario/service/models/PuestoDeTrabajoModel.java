package es.ediae.master.programacion.gestionusuario.service.models;

import es.ediae.master.programacion.gestionusuario.controller.DTO.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.PuestoDeTrabajoPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

public class PuestoDeTrabajoModel {

    private Integer id;

    private String nombre;

    public PuestoDeTrabajoModel(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PuestoDeTrabajoModel() {
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

    public static PuestoDeTrabajoModel fromEntity(PuestoDeTrabajoEntity entity) {
        return new PuestoDeTrabajoModel(entity.getId(), entity.getNombre());
    }

    public static PuestoDeTrabajoModel fromDTO(PuestoDeTrabajoDTO dto) {
        return new PuestoDeTrabajoModel(dto.getId(), dto.getNombre());
    }

    public static PuestoDeTrabajoModel fromPostDTO(PuestoDeTrabajoPostDTO postDTO) {
        return new PuestoDeTrabajoModel(null, postDTO.getNombre());
    }

}
