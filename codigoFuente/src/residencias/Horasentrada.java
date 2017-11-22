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
@Table(name = "Horas_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horasentrada.findAll", query = "SELECT h FROM Horasentrada h")
    , @NamedQuery(name = "Horasentrada.findByIdHoras", query = "SELECT h FROM Horasentrada h WHERE h.idHoras = :idHoras")
    , @NamedQuery(name = "Horasentrada.findByFecha", query = "SELECT h FROM Horasentrada h WHERE h.fecha = :fecha")})
public class Horasentrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHoras")
    private Integer idHoras;
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

    public Horasentrada() {
    }

    public Horasentrada(Integer idHoras) {
        this.idHoras = idHoras;
    }

    public Horasentrada(Integer idHoras, Date fecha) {
        this.idHoras = idHoras;
        this.fecha = fecha;
    }

    public Integer getIdHoras() {
        return idHoras;
    }

    public void setIdHoras(Integer idHoras) {
        this.idHoras = idHoras;
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
        hash += (idHoras != null ? idHoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horasentrada)) {
            return false;
        }
        Horasentrada other = (Horasentrada) object;
        if ((this.idHoras == null && other.idHoras != null) || (this.idHoras != null && !this.idHoras.equals(other.idHoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Horasentrada[ idHoras=" + idHoras + " ]";
    }
    
}
