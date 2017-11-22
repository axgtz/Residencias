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
@Table(name = "Actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")
    , @NamedQuery(name = "Actividades.findByIdActividades", query = "SELECT a FROM Actividades a WHERE a.idActividades = :idActividades")
    , @NamedQuery(name = "Actividades.findByFecha", query = "SELECT a FROM Actividades a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Actividades.findByObligatoria", query = "SELECT a FROM Actividades a WHERE a.obligatoria = :obligatoria")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idActividades")
    private Integer idActividades;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "obligatoria")
    private boolean obligatoria;
    @JoinColumn(name = "Prefecto_idPrefecto", referencedColumnName = "idPrefecto")
    @ManyToOne(optional = false)
    private Prefecto prefectoidPrefecto;

    public Actividades() {
    }

    public Actividades(Integer idActividades) {
        this.idActividades = idActividades;
    }

    public Actividades(Integer idActividades, Date fecha, String descripcion, boolean obligatoria) {
        this.idActividades = idActividades;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.obligatoria = obligatoria;
    }

    public Integer getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(Integer idActividades) {
        this.idActividades = idActividades;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }

    public Prefecto getPrefectoidPrefecto() {
        return prefectoidPrefecto;
    }

    public void setPrefectoidPrefecto(Prefecto prefectoidPrefecto) {
        this.prefectoidPrefecto = prefectoidPrefecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividades != null ? idActividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.idActividades == null && other.idActividades != null) || (this.idActividades != null && !this.idActividades.equals(other.idActividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Actividades[ idActividades=" + idActividades + " ]";
    }
    
}
