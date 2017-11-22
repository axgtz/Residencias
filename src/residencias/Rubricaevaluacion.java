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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Rubricaevaluacion.findByAlumnoidAlumno", query = "SELECT r FROM Rubricaevaluacion r WHERE r.rubricaevaluacionPK.alumnoidAlumno = :alumnoidAlumno")
    , @NamedQuery(name = "Rubricaevaluacion.findByPrefectoidPrefecto", query = "SELECT r FROM Rubricaevaluacion r WHERE r.rubricaevaluacionPK.prefectoidPrefecto = :prefectoidPrefecto")
    , @NamedQuery(name = "Rubricaevaluacion.findByFecha", query = "SELECT r FROM Rubricaevaluacion r WHERE r.fecha = :fecha")})
public class Rubricaevaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RubricaevaluacionPK rubricaevaluacionPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "Prefecto_idPrefecto", referencedColumnName = "idPrefecto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prefecto prefecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubricaevaluacion")
    private Collection<Concepto> conceptoCollection;

    public Rubricaevaluacion() {
    }

    public Rubricaevaluacion(RubricaevaluacionPK rubricaevaluacionPK) {
        this.rubricaevaluacionPK = rubricaevaluacionPK;
    }

    public Rubricaevaluacion(RubricaevaluacionPK rubricaevaluacionPK, Date fecha) {
        this.rubricaevaluacionPK = rubricaevaluacionPK;
        this.fecha = fecha;
    }

    public Rubricaevaluacion(int alumnoidAlumno, int prefectoidPrefecto) {
        this.rubricaevaluacionPK = new RubricaevaluacionPK(alumnoidAlumno, prefectoidPrefecto);
    }

    public RubricaevaluacionPK getRubricaevaluacionPK() {
        return rubricaevaluacionPK;
    }

    public void setRubricaevaluacionPK(RubricaevaluacionPK rubricaevaluacionPK) {
        this.rubricaevaluacionPK = rubricaevaluacionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Prefecto getPrefecto() {
        return prefecto;
    }

    public void setPrefecto(Prefecto prefecto) {
        this.prefecto = prefecto;
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
        hash += (rubricaevaluacionPK != null ? rubricaevaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rubricaevaluacion)) {
            return false;
        }
        Rubricaevaluacion other = (Rubricaevaluacion) object;
        if ((this.rubricaevaluacionPK == null && other.rubricaevaluacionPK != null) || (this.rubricaevaluacionPK != null && !this.rubricaevaluacionPK.equals(other.rubricaevaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Rubricaevaluacion[ rubricaevaluacionPK=" + rubricaevaluacionPK + " ]";
    }
    
}
