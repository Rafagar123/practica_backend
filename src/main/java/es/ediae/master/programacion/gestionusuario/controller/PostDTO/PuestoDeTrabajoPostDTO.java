package es.ediae.master.programacion.gestionusuario.controller.PostDTO;

public class PuestoDeTrabajoPostDTO {

    private String nombre;

    public PuestoDeTrabajoPostDTO(String nombre) {
        this.nombre = nombre;
    }

    public PuestoDeTrabajoPostDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
