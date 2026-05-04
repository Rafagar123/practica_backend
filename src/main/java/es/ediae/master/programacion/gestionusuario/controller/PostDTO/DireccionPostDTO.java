package es.ediae.master.programacion.gestionusuario.controller.PostDTO;

import es.ediae.master.programacion.gestionusuario.controller.DTO.UsuarioDTO;

public class DireccionPostDTO {

    private String nombreCalle;

    private Integer numeroCalle;

    private UsuarioDTO usuario;

    private Boolean direccionPrincipal;

    public DireccionPostDTO(String nombreCalle, Integer numeroCalle, UsuarioDTO usuario,
            Boolean direccionPrincipal) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }

    public DireccionPostDTO() {
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

}
