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
@Table(name = "Ausencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ausencia.findAll", query = "SELECT a FROM Ausencia a")
    , @NamedQuery(name = "Ausencia.findByIdAusencia", query = "SELECT a FROM Ausencia a WHERE a.idAusencia = :idAusencia")
    , @NamedQuery(name = "Ausencia.findByFecha", query = "SELECT a FROM Ausencia a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Ausencia.findByJustificada", query = "SELECT a FROM Ausencia a WHERE a.justificada = :justificada")
    , @NamedQuery(name = "Ausencia.findByMotivo", query = "SELECT a FROM Ausencia a WHERE a.motivo = :motivo")
    , @NamedQuery(name = "Ausencia.findByComentarios", query = "SELECT a FROM Ausencia a WHERE a.comentarios = :comentarios")})
public class Ausencia implements Serializable {

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAusencia")
    private Integer idAusencia;
    @Basic(optional = false)
    @Column(name = "justificada")
    private boolean justificada;
    @Basic(optional = false)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno alumnoidAlumno;

    public Ausencia() {
    }

    public Ausencia(Integer idAusencia) {
        this.idAusencia = idAusencia;
    }

    public Ausencia(Integer idAusencia, Date fecha, boolean justificada, String motivo) {
        this.idAusencia = idAusencia;
        this.fecha = fecha;
        this.justificada = justificada;
        this.motivo = motivo;
    }

    public Integer getIdAusencia() {
        return idAusencia;
    }

    public void setIdAusencia(Integer idAusencia) {
        this.idAusencia = idAusencia;
    }


    public boolean getJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (idAusencia != null ? idAusencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ausencia)) {
            return false;
        }
        Ausencia other = (Ausencia) object;
        if ((this.idAusencia == null && other.idAusencia != null) || (this.idAusencia != null && !this.idAusencia.equals(other.idAusencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Ausencia[ idAusencia=" + idAusencia + " ]";
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
