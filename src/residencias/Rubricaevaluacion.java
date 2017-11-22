/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author burela
 */
@Entity
@Table(name = "Rubrica_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rubricaevaluacion.findAll", query = "SELECT r FROM Rubricaevaluacion r")
    , @NamedQuery(name = "Rubricaevaluacion.findByIdRubrica", query = "SELECT r FROM Rubricaevaluacion r WHERE r.idRubrica = :idRubrica")
    , @NamedQuery(name = "Rubricaevaluacion.findByFecha", query = "SELECT r FROM Rubricaevaluacion r WHERE r.fecha = :fecha")})
public class Rubricaevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRubrica")
    private Integer idRubrica;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno")
    @ManyToOne(optional = false)
    private Alumno alumnoidAlumno;
    @JoinColumn(name = "Prefecto_idPrefecto", referencedColumnName = "idPrefecto")
    @ManyToOne(optional = false)
    private Prefecto prefectoidPrefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubricaevaluacionidRubrica")
    private Collection<Concepto> conceptoCollection;

    public Rubricaevaluacion() {
    }

    public Rubricaevaluacion(Integer idRubrica) {
        this.idRubrica = idRubrica;
    }

    public Rubricaevaluacion(Integer idRubrica, Date fecha) {
        this.idRubrica = idRubrica;
        this.fecha = fecha;
    }

    public Integer getIdRubrica() {
        return idRubrica;
    }

    public void setIdRubrica(Integer idRubrica) {
        this.idRubrica = idRubrica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(Alumno alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public Prefecto getPrefectoidPrefecto() {
        return prefectoidPrefecto;
    }

    public void setPrefectoidPrefecto(Prefecto prefectoidPrefecto) {
        this.prefectoidPrefecto = prefectoidPrefecto;
    }

    @XmlTransient
    public Collection<Concepto> getConceptoCollection() {
        return conceptoCollection;
    }

    public void setConceptoCollection(Collection<Concepto> conceptoCollection) {
        this.conceptoCollection = conceptoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubrica != null ? idRubrica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rubricaevaluacion)) {
            return false;
        }
        Rubricaevaluacion other = (Rubricaevaluacion) object;
        if ((this.idRubrica == null && other.idRubrica != null) || (this.idRubrica != null && !this.idRubrica.equals(other.idRubrica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Rubricaevaluacion[ idRubrica=" + idRubrica + " ]";
    }
    
}
