package es.ediae.master.programacion.gestionusuario.controller.DTO;

import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

public class DireccionDTO {
    
    private Integer id;

    private String nombreCalle;

    private Integer numeroCalle;

    private UsuarioDTO usuario;

    private Boolean direccionPrincipal;

    public DireccionDTO(Integer id, String nombreCalle, Integer numeroCalle, UsuarioDTO usuario,
            Boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }

    public DireccionDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static DireccionDTO fromModel(DireccionModel direccionModel) {
        return new DireccionDTO(
                direccionModel.getId(),
                direccionModel.getNombreCalle(),
                direccionModel.getNumeroCalle(),
                UsuarioDTO.fromModel(direccionModel.getUsuario()),
                direccionModel.getDireccionPrincipal());
    }
}
