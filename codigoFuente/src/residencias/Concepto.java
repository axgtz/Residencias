/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burela
 */
@Entity
@Table(name = "Concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c")
    , @NamedQuery(name = "Concepto.findByIdConcepto", query = "SELECT c FROM Concepto c WHERE c.idConcepto = :idConcepto")
    , @NamedQuery(name = "Concepto.findByDescripcion", query = "SELECT c FROM Concepto c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Concepto.findByPorcentaje", query = "SELECT c FROM Concepto c WHERE c.porcentaje = :porcentaje")})
public class Concepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idConcepto")
    private Integer idConcepto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private int porcentaje;
    @JoinColumns({
        @JoinColumn(name = "Rubrica_evaluacion_Alumno_idAlumno", referencedColumnName = "Alumno_idAlumno")
        , @JoinColumn(name = "Rubrica_evaluacion_Prefecto_idPrefecto", referencedColumnName = "Prefecto_idPrefecto")})
    @ManyToOne(optional = false)
    private Rubricaevaluacion rubricaevaluacion;

    public Concepto() {
    }

    public Concepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Concepto(Integer idConcepto, String descripcion, int porcentaje) {
        this.idConcepto = idConcepto;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Rubricaevaluacion getRubricaevaluacion() {
        return rubricaevaluacion;
    }

    public void setRubricaevaluacion(Rubricaevaluacion rubricaevaluacion) {
        this.rubricaevaluacion = rubricaevaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcepto != null ? idConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.idConcepto == null && other.idConcepto != null) || (this.idConcepto != null && !this.idConcepto.equals(other.idConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Concepto[ idConcepto=" + idConcepto + " ]";
    }
    
}
