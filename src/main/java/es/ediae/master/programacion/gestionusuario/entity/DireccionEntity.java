package es.ediae.master.programacion.gestionusuario.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_calle", nullable = false)
    private String nombreCalle;

    @Column(name = "numero_calle", nullable = true)
    private Integer numeroCalle;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "direccion_principal", nullable = false)
    private Boolean direccionPrincipal;

    public DireccionEntity(Integer id, String nombreCalle, Integer numeroCalle, UsuarioEntity usuario,
            Boolean direccionPrincipal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.usuario = usuario;
        this.direccionPrincipal = direccionPrincipal;
    }

    public DireccionEntity() {
    }

}
