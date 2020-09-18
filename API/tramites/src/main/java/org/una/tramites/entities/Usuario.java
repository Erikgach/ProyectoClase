package org.una.tramites.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", length = 100)
    private String nombreCompleto;

    @Column(length = 100, name = "password_encriptado")
    private String passwordEncriptado;

    @Column(length = 25, unique = true)
    private String cedula;

    @Column
    private boolean estado;
/*
    @Column(name = "departamento_id")
    private Long DepartamentoId;*/

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "es_jefe")
    private boolean esJefe;

    @ManyToOne
    @JoinColumn(name="departamentos_id")
    private Departamento departamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PermisoOtorgado> permisosOtorgados= new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        esJefe=false;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }




    public String getCedula() {
        return cedula;
    }

    public String getPasswordEncriptado() {
        return passwordEncriptado;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public void setPasswordEncriptado(String password) {
        passwordEncriptado = password;
    }

    public void setNombreCompleto(String nombre) {
        nombreCompleto = nombre;
    }
}

