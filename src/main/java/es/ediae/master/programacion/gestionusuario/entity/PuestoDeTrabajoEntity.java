package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "puesto_de_trabajo")
public class PuestoDeTrabajoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    public PuestoDeTrabajoEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public PuestoDeTrabajoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
