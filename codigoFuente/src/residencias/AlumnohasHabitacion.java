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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Alumno_has_Habitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnohasHabitacion.findAll", query = "SELECT a FROM AlumnohasHabitacion a")
    , @NamedQuery(name = "AlumnohasHabitacion.findByAlumnoidAlumno", query = "SELECT a FROM AlumnohasHabitacion a WHERE a.alumnohasHabitacionPK.alumnoidAlumno = :alumnoidAlumno")
    , @NamedQuery(name = "AlumnohasHabitacion.findByHabitacionidHabitacion", query = "SELECT a FROM AlumnohasHabitacion a WHERE a.alumnohasHabitacionPK.habitacionidHabitacion = :habitacionidHabitacion")
    , @NamedQuery(name = "AlumnohasHabitacion.findByFechaAsignacion", query = "SELECT a FROM AlumnohasHabitacion a WHERE a.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "AlumnohasHabitacion.findByFechaSalida", query = "SELECT a FROM AlumnohasHabitacion a WHERE a.fechaSalida = :fechaSalida")})
public class AlumnohasHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnohasHabitacionPK alumnohasHabitacionPK;
    @Basic(optional = false)
    @Column(name = "fechaAsignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @Column(name = "fechaSalida")
    private String fechaSalida;
    @Lob
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "Habitacion_idHabitacion", referencedColumnName = "idHabitacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;

    public AlumnohasHabitacion() {
    }

    public AlumnohasHabitacion(AlumnohasHabitacionPK alumnohasHabitacionPK) {
        this.alumnohasHabitacionPK = alumnohasHabitacionPK;
    }

    public AlumnohasHabitacion(AlumnohasHabitacionPK alumnohasHabitacionPK, Date fechaAsignacion, String fechaSalida) {
        this.alumnohasHabitacionPK = alumnohasHabitacionPK;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaSalida = fechaSalida;
    }

    public AlumnohasHabitacion(int alumnoidAlumno, int habitacionidHabitacion) {
        this.alumnohasHabitacionPK = new AlumnohasHabitacionPK(alumnoidAlumno, habitacionidHabitacion);
    }

    public AlumnohasHabitacionPK getAlumnohasHabitacionPK() {
        return alumnohasHabitacionPK;
    }

    public void setAlumnohasHabitacionPK(AlumnohasHabitacionPK alumnohasHabitacionPK) {
        this.alumnohasHabitacionPK = alumnohasHabitacionPK;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alumnohasHabitacionPK != null ? alumnohasHabitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnohasHabitacion)) {
            return false;
        }
        AlumnohasHabitacion other = (AlumnohasHabitacion) object;
        if ((this.alumnohasHabitacionPK == null && other.alumnohasHabitacionPK != null) || (this.alumnohasHabitacionPK != null && !this.alumnohasHabitacionPK.equals(other.alumnohasHabitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.AlumnohasHabitacion[ alumnohasHabitacionPK=" + alumnohasHabitacionPK + " ]";
    }
    
}
