/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MI PC
 */
@Entity
@Table(name = "proyectos", catalog = "municipalidad_lq", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyectos.findByNomProyecto", query = "SELECT p FROM Proyectos p WHERE p.nomProyecto = :nomProyecto")
    , @NamedQuery(name = "Proyectos.findByFechaInicio", query = "SELECT p FROM Proyectos p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyectos.findByFechaFinalizacion", query = "SELECT p FROM Proyectos p WHERE p.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "Proyectos.findByMonto", query = "SELECT p FROM Proyectos p WHERE p.monto = :monto")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nom_proyecto", nullable = false, length = 50)
    private String nomProyecto;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_finalizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private float monto;

    public Proyectos() {
    }

    public Proyectos(Integer codigo) {
        this.codigo = codigo;
    }

    public Proyectos(Integer codigo, String nomProyecto, Date fechaInicio, Date fechaFinalizacion, float monto) {
        this.codigo = codigo;
        this.nomProyecto = nomProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.monto = monto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectos[ codigo=" + codigo + " ]";
    }
    
}
