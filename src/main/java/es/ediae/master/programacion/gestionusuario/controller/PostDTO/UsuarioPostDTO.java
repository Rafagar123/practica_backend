package es.ediae.master.programacion.gestionusuario.controller.PostDTO;

import java.sql.Date;
import java.sql.Time;

import es.ediae.master.programacion.gestionusuario.controller.DTO.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.controller.DTO.PuestoDeTrabajoDTO;

public class UsuarioPostDTO {

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

    public UsuarioPostDTO(String nickUsuario, String contrasena, Date fechaHoraCreacion,
            GeneroDTO genero, String nombre, String primerApellido, String segundoApellido,
            Date fechaNacimiento, Time horaDesayuno, PuestoDeTrabajoDTO puestoDeTrabajo) {
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

    public UsuarioPostDTO() {
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

}
