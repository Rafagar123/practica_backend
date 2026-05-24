package es.ediae.master.programacion.gestionusuario.controller.PostDTO;

public class DireccionPostDTO {

    private String nombreCalle;

    private Integer numeroCalle;

    private Integer usuarioId;

    private Boolean direccionPrincipal;

    public DireccionPostDTO(String nombreCalle, Integer numeroCalle, Integer usuarioId,
            Boolean direccionPrincipal) {
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuarioId = usuarioId;
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

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

}
