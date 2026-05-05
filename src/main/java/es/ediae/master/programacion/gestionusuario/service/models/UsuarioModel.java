package es.ediae.master.programacion.gestionusuario.service.models;

import java.sql.Date;
import java.sql.Time;

import es.ediae.master.programacion.gestionusuario.controller.DTO.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

public class UsuarioModel {

    private Integer id;

    private String nickUsuario;

    private String contrasena;

    private Date fechaHoraCreacion;

    private GeneroModel generoModel;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private Date fechaNacimiento;

    private Time horaDesayuno;

    private PuestoDeTrabajoModel puestoDeTrabajoModel;

    public UsuarioModel(Integer id, String nickUsuario, String contrasena, Date fechaHoraCreacion,
            GeneroModel generoModel, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento,
            Time horaDesayuno, PuestoDeTrabajoModel puestoDeTrabajoModel) {
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

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Time getHoraDesayuno() {
        return horaDesayuno;
    }

    public void setHoraDesayuno(Time horaDesayuno) {
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
                GeneroModel.fromDTO(usuarioDTO.getGeneroDTO()),
                usuarioDTO.getNombre(),
                usuarioDTO.getPrimerApellido(),
                usuarioDTO.getSegundoApellido(),
                usuarioDTO.getFechaNacimiento(),
                usuarioDTO.getHoraDesayuno(),
                PuestoDeTrabajoModel.fromDTO(usuarioDTO.getPuestoDeTrabajoDTO()));
    }

    public static UsuarioModel fromPostDTO(UsuarioPostDTO usuarioPostDTO) {
        return new UsuarioModel(
                null,
                usuarioPostDTO.getNickUsuario(),
                usuarioPostDTO.getContrasena(),
                null,
                GeneroModel.fromDTO(usuarioPostDTO.getGeneroDTO()),
                usuarioPostDTO.getNombre(),
                usuarioPostDTO.getPrimerApellido(),
                usuarioPostDTO.getSegundoApellido(),
                usuarioPostDTO.getFechaNacimiento(),
                usuarioPostDTO.getHoraDesayuno(),
                PuestoDeTrabajoModel.fromDTO(usuarioPostDTO.getPuestoDeTrabajoDTO()));
    }

}
