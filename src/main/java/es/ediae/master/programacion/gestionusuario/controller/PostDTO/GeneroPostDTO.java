package es.ediae.master.programacion.gestionusuario.controller.PostDTO;

public class GeneroPostDTO {

    private String nombre;

    public GeneroPostDTO(String nombre) {
        this.nombre = nombre;
    }

    public GeneroPostDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
