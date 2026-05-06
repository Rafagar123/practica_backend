package es.ediae.master.programacion.gestionusuario.service.models;

import java.time.*;

import es.ediae.master.programacion.gestionusuario.controller.DTO.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public class UsuarioModel {

    private Integer id;

    private String nickUsuario;

    private String contrasena;

    private LocalDateTime fechaHoraCreacion;

    private GeneroModel generoModel;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private LocalDate fechaNacimiento;

    private LocalTime horaDesayuno;

    private PuestoDeTrabajoModel puestoDeTrabajoModel;

    public UsuarioModel(Integer id, String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion,
            GeneroModel generoModel, String nombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento,
            LocalTime horaDesayuno, PuestoDeTrabajoModel puestoDeTrabajoModel) {
        this.id = id;
        this.nickUsuario = nickUsuario;
        this.contrasena = contrasena;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.generoModel = generoModel;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.puestoDeTrabajoModel = puestoDeTrabajoModel;
    }

    public UsuarioModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public GeneroModel getGeneroModel() {
        return generoModel;
    }

    public void setGeneroModel(GeneroModel generoModel) {
        this.generoModel = generoModel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalTime getHoraDesayuno() {
        return horaDesayuno;
    }

    public void setHoraDesayuno(LocalTime horaDesayuno) {
        this.horaDesayuno = horaDesayuno;
    }

    public PuestoDeTrabajoModel getPuestoDeTrabajoModel() {
        return puestoDeTrabajoModel;
    }

    public void setPuestoDeTrabajoModel(PuestoDeTrabajoModel puestoDeTrabajoModel) {
        this.puestoDeTrabajoModel = puestoDeTrabajoModel;
    }

    public static UsuarioModel fromEntity(UsuarioEntity usuarioEntity) {
        return new UsuarioModel(
                usuarioEntity.getId(),
                usuarioEntity.getNickUsuario(),
                usuarioEntity.getContrasena(),
                usuarioEntity.getFechaHoraCreacion(),
                GeneroModel.fromEntity(usuarioEntity.getGenero()),
                usuarioEntity.getNombre(),
                usuarioEntity.getPrimerApellido(),
                usuarioEntity.getSegundoApellido(),
                usuarioEntity.getFechaNacimiento(),
                usuarioEntity.getHoraDesayuno(),
                PuestoDeTrabajoModel.fromEntity(usuarioEntity.getPuestoDeTrabajo()));

    }

    public static UsuarioModel fromDTO(UsuarioDTO usuarioDTO) {
        return new UsuarioModel(
                usuarioDTO.getId(),
                usuarioDTO.getNickUsuario(),
                usuarioDTO.getContrasena(),
                usuarioDTO.getFechaHoraCreacion(),
                GeneroModel.fromDTO(usuarioDTO.getGenero()),
                usuarioDTO.getNombre(),
                usuarioDTO.getPrimerApellido(),
                usuarioDTO.getSegundoApellido(),
                usuarioDTO.getFechaNacimiento(),
                usuarioDTO.getHoraDesayuno(),
                PuestoDeTrabajoModel.fromDTO(usuarioDTO.getPuestoDeTrabajo()));
    }

    public static UsuarioModel fromPostDTO(UsuarioPostDTO usuarioPostDTO) {
        return new UsuarioModel(
                null,
                usuarioPostDTO.getNickUsuario(),
                usuarioPostDTO.getContrasena(),
                null,
                GeneroModel.fromDTO(usuarioPostDTO.getGenero()),
                usuarioPostDTO.getNombre(),
                usuarioPostDTO.getPrimerApellido(),
                usuarioPostDTO.getSegundoApellido(),
                usuarioPostDTO.getFechaNacimiento(),
                usuarioPostDTO.getHoraDesayuno(),
                PuestoDeTrabajoModel.fromDTO(usuarioPostDTO.getPuestoDeTrabajo()));
    }

}
