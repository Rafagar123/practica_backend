package es.ediae.master.programacion.gestionusuario.service.models;

import es.ediae.master.programacion.gestionusuario.controller.DTO.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.DireccionPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public class DireccionModel {
    private Integer id;

    private String nombreCalle;

    private Integer numeroCalle;

    private UsuarioModel usuario;

    private Boolean direccionPrincipal;

    public DireccionModel(Integer id, String nombreCalle, Integer numeroCalle, UsuarioModel usuario,
            Boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }

    public DireccionModel() {
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Boolean getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(Boolean direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public static DireccionModel fromEntity(DireccionEntity direccionEntity) {
        return new DireccionModel(
                direccionEntity.getId(),
                direccionEntity.getNombreCalle(),
                direccionEntity.getNumeroCalle(),
                UsuarioModel.fromEntity(direccionEntity.getUsuario()),
                direccionEntity.getDireccionPrincipal());
    }

    public static DireccionModel fromDTO(DireccionDTO direccionDTO) {
        return new DireccionModel(
                direccionDTO.getId(),
                direccionDTO.getNombreCalle(),
                direccionDTO.getNumeroCalle(),
               	UsuarioModel.fromDTO(direccionDTO.getUsuario()),
                direccionDTO.getDireccionPrincipal());
    }

    public static DireccionModel fromPostDTO(DireccionPostDTO direccionPostDTO) {
        return new DireccionModel(
                null,
                direccionPostDTO.getNombreCalle(),
                direccionPostDTO.getNumeroCalle(),
                UsuarioModel.fromDTO(direccionPostDTO.getUsuario()),
                direccionPostDTO.getDireccionPrincipal());
    }

}
