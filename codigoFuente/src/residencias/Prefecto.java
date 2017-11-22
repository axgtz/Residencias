/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author burela
 */
@Entity
@Table(name = "Prefecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prefecto.findAll", query = "SELECT p FROM Prefecto p")
    , @NamedQuery(name = "Prefecto.findByIdPrefecto", query = "SELECT p FROM Prefecto p WHERE p.idPrefecto = :idPrefecto")
    , @NamedQuery(name = "Prefecto.findByNombre", query = "SELECT p FROM Prefecto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Prefecto.findByApellido", query = "SELECT p FROM Prefecto p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Prefecto.findByNomina", query = "SELECT p FROM Prefecto p WHERE p.nomina = :nomina")
    , @NamedQuery(name = "Prefecto.findByEmail", query = "SELECT p FROM Prefecto p WHERE p.email = :email")})
public class Prefecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPrefecto")
    private Integer idPrefecto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nomina")
    private String nomina;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefecto")
    private Collection<Rubricaevaluacion> rubricaevaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefectoidPrefecto")
    private Collection<Actividades> actividadesCollection;

    public Prefecto() {
    }

    public Prefecto(Integer idPrefecto) {
        this.idPrefecto = idPrefecto;
    }

    public Prefecto(Integer idPrefecto, String nombre, String apellido, String nomina, String email) {
        this.idPrefecto = idPrefecto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nomina = nomina;
        this.email = email;
    }

    public Integer getIdPrefecto() {
        return idPrefecto;
    }

    public void setIdPrefecto(Integer idPrefecto) {
        this.idPrefecto = idPrefecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Rubricaevaluacion> getRubricaevaluacionCollection() {
        return rubricaevaluacionCollection;
    }

    public void setRubricaevaluacionCollection(Collection<Rubricaevaluacion> rubricaevaluacionCollection) {
        this.rubricaevaluacionCollection = rubricaevaluacionCollection;
    }

    @XmlTransient
    public Collection<Actividades> getActividadesCollection() {
        return actividadesCollection;
    }

    public void setActividadesCollection(Collection<Actividades> actividadesCollection) {
        this.actividadesCollection = actividadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrefecto != null ? idPrefecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefecto)) {
            return false;
        }
        Prefecto other = (Prefecto) object;
        if ((this.idPrefecto == null && other.idPrefecto != null) || (this.idPrefecto != null && !this.idPrefecto.equals(other.idPrefecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Prefecto[ idPrefecto=" + idPrefecto + " ]";
    }
    
}
