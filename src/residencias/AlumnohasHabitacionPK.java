/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author burela
 */
@Embeddable
public class AlumnohasHabitacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Alumno_idAlumno")
    private int alumnoidAlumno;
    @Basic(optional = false)
    @Column(name = "Habitacion_idHabitacion")
    private int habitacionidHabitacion;

    public AlumnohasHabitacionPK() {
    }

    public AlumnohasHabitacionPK(int alumnoidAlumno, int habitacionidHabitacion) {
        this.alumnoidAlumno = alumnoidAlumno;
        this.habitacionidHabitacion = habitacionidHabitacion;
    }

    public int getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(int alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public int getHabitacionidHabitacion() {
        return habitacionidHabitacion;
    }

    public void setHabitacionidHabitacion(int habitacionidHabitacion) {
        this.habitacionidHabitacion = habitacionidHabitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumnoidAlumno;
        hash += (int) habitacionidHabitacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnohasHabitacionPK)) {
            return false;
        }
        AlumnohasHabitacionPK other = (AlumnohasHabitacionPK) object;
        if (this.alumnoidAlumno != other.alumnoidAlumno) {
            return false;
        }
        if (this.habitacionidHabitacion != other.habitacionidHabitacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.AlumnohasHabitacionPK[ alumnoidAlumno=" + alumnoidAlumno + ", habitacionidHabitacion=" + habitacionidHabitacion + " ]";
    }
    
}
