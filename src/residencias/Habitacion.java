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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h")
    , @NamedQuery(name = "Habitacion.findByIdHabitacion", query = "SELECT h FROM Habitacion h WHERE h.idHabitacion = :idHabitacion")
    , @NamedQuery(name = "Habitacion.findByNumero", query = "SELECT h FROM Habitacion h WHERE h.numero = :numero")
    , @NamedQuery(name = "Habitacion.findByCapacidad", query = "SELECT h FROM Habitacion h WHERE h.capacidad = :capacidad")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHabitacion")
    private Integer idHabitacion;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitacion")
    private Collection<AlumnohasHabitacion> alumnohasHabitacionCollection;

    public Habitacion() {
    }

    public Habitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Habitacion(Integer idHabitacion, int numero, int capacidad) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<AlumnohasHabitacion> getAlumnohasHabitacionCollection() {
        return alumnohasHabitacionCollection;
    }

    public void setAlumnohasHabitacionCollection(Collection<AlumnohasHabitacion> alumnohasHabitacionCollection) {
        this.alumnohasHabitacionCollection = alumnohasHabitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabitacion != null ? idHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.idHabitacion == null && other.idHabitacion != null) || (this.idHabitacion != null && !this.idHabitacion.equals(other.idHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Habitacion[ idHabitacion=" + idHabitacion + " ]";
    }
    
}
