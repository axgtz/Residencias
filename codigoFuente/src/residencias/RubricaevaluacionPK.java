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
public class RubricaevaluacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Alumno_idAlumno")
    private int alumnoidAlumno;
    @Basic(optional = false)
    @Column(name = "Prefecto_idPrefecto")
    private int prefectoidPrefecto;

    public RubricaevaluacionPK() {
    }

    public RubricaevaluacionPK(int alumnoidAlumno, int prefectoidPrefecto) {
        this.alumnoidAlumno = alumnoidAlumno;
        this.prefectoidPrefecto = prefectoidPrefecto;
    }

    public int getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(int alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public int getPrefectoidPrefecto() {
        return prefectoidPrefecto;
    }

    public void setPrefectoidPrefecto(int prefectoidPrefecto) {
        this.prefectoidPrefecto = prefectoidPrefecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alumnoidAlumno;
        hash += (int) prefectoidPrefecto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubricaevaluacionPK)) {
            return false;
        }
        RubricaevaluacionPK other = (RubricaevaluacionPK) object;
        if (this.alumnoidAlumno != other.alumnoidAlumno) {
            return false;
        }
        if (this.prefectoidPrefecto != other.prefectoidPrefecto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.RubricaevaluacionPK[ alumnoidAlumno=" + alumnoidAlumno + ", prefectoidPrefecto=" + prefectoidPrefecto + " ]";
    }
    
}
