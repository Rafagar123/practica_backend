package es.ediae.master.programacion.gestionusuario.controller.DTO;

import java.sql.Date;
import java.sql.Time;

import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

public class UsuarioDTO {

    private Integer id;

    private String nickUsuario;

    private String contrasena;

    private Date fechaHoraCreacion;

    private GeneroDTO genero;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private Date fechaNacimiento;

    private Time horaDesayuno;

    private PuestoDeTrabajoDTO puestoDeTrabajo;

    public UsuarioDTO(Integer id, String nickUsuario, String contrasena, Date fechaHoraCreacion,
            GeneroDTO genero, String nombre, String primerApellido, String segundoApellido,
            Date fechaNacimiento, Time horaDesayuno, PuestoDeTrabajoDTO puestoDeTrabajo) {
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

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public GeneroDTO getGeneroDTO() {
        return genero;
    }

    public void setGeneroDTO(GeneroDTO genero) {
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

    public PuestoDeTrabajoDTO getPuestoDeTrabajoDTO() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajoDTO(PuestoDeTrabajoDTO puestoDeTrabajo) {
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
