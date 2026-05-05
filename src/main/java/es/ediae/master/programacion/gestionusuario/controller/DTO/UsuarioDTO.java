package es.ediae.master.programacion.gestionusuario.controller.DTO;

import java.sql.Time;
import java.time.*;

import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

public class UsuarioDTO {

    private Integer id;

    private String nickUsuario;

    private String contrasena;

    private LocalDateTime fechaHoraCreacion;

    private GeneroDTO genero;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private LocalDate fechaNacimiento;

    private LocalTime horaDesayuno;

    private PuestoDeTrabajoDTO puestoDeTrabajo;

    public UsuarioDTO(Integer id, String nickUsuario, String contrasena, LocalDateTime fechaHoraCreacion,
            GeneroDTO genero, String nombre, String primerApellido, String segundoApellido,
            LocalDate fechaNacimiento, LocalTime horaDesayuno, PuestoDeTrabajoDTO puestoDeTrabajo) {
        this.id = id;
        this.nickUsuario = nickUsuario;
        this.contrasena = contrasena;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.genero = genero;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.horaDesayuno = horaDesayuno;
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public UsuarioDTO() {
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

    public GeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
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

    public PuestoDeTrabajoDTO getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(PuestoDeTrabajoDTO puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public static UsuarioDTO fromModel(UsuarioModel usuarioModel) {
        return new UsuarioDTO(
                usuarioModel.getId(),
                usuarioModel.getNickUsuario(),
                usuarioModel.getContrasena(),
                usuarioModel.getFechaHoraCreacion(),
                GeneroDTO.fromModel(usuarioModel.getGeneroModel()),
                usuarioModel.getNombre(),
                usuarioModel.getPrimerApellido(),
                usuarioModel.getSegundoApellido(),
                usuarioModel.getFechaNacimiento(),
                usuarioModel.getHoraDesayuno(),
                PuestoDeTrabajoDTO.fromModel(usuarioModel.getPuestoDeTrabajoModel()));
    }
}
