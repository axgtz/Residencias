/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burela
 */
@Entity
@Table(name = "Indisciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indisciplina.findAll", query = "SELECT i FROM Indisciplina i")
    , @NamedQuery(name = "Indisciplina.findByIdIndisciplina", query = "SELECT i FROM Indisciplina i WHERE i.idIndisciplina = :idIndisciplina")
    , @NamedQuery(name = "Indisciplina.findByFecha", query = "SELECT i FROM Indisciplina i WHERE i.fecha = :fecha")})
public class Indisciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIndisciplina")
    private Integer idIndisciplina;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno alumnoidAlumno;

    public Indisciplina() {
    }

    public Indisciplina(Integer idIndisciplina) {
        this.idIndisciplina = idIndisciplina;
    }

    public Indisciplina(Integer idIndisciplina, String descripcion, Date fecha) {
        this.idIndisciplina = idIndisciplina;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdIndisciplina() {
        return idIndisciplina;
    }

    public void setIdIndisciplina(Integer idIndisciplina) {
        this.idIndisciplina = idIndisciplina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Alumno getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(Alumno alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndisciplina != null ? idIndisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indisciplina)) {
            return false;
        }
        Indisciplina other = (Indisciplina) object;
        if ((this.idIndisciplina == null && other.idIndisciplina != null) || (this.idIndisciplina != null && !this.idIndisciplina.equals(other.idIndisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Indisciplina[ idIndisciplina=" + idIndisciplina + " ]";
    }
    
}
