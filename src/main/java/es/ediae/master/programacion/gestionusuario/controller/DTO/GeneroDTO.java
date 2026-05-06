package es.ediae.master.programacion.gestionusuario.controller.DTO;

import es.ediae.master.programacion.gestionusuario.service.models.GeneroModel;

public class GeneroDTO {

    private Integer id;

    private String nombre;

    public GeneroDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public GeneroDTO() {
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

    public static GeneroDTO fromModel(GeneroModel generoModel) {
        return new GeneroDTO(
                generoModel.getId(),
                generoModel.getNombre());
    }
}
