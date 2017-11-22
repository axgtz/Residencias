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
public class PerfilmedicoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idPerfil")
    private int idPerfil;
    @Basic(optional = false)
    @Column(name = "Alumno_idAlumno")
    private int alumnoidAlumno;

    public PerfilmedicoPK() {
    }

    public PerfilmedicoPK(int idPerfil, int alumnoidAlumno) {
        this.idPerfil = idPerfil;
        this.alumnoidAlumno = alumnoidAlumno;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getAlumnoidAlumno() {
        return alumnoidAlumno;
    }

    public void setAlumnoidAlumno(int alumnoidAlumno) {
        this.alumnoidAlumno = alumnoidAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPerfil;
        hash += (int) alumnoidAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilmedicoPK)) {
            return false;
        }
        PerfilmedicoPK other = (PerfilmedicoPK) object;
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        if (this.alumnoidAlumno != other.alumnoidAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.PerfilmedicoPK[ idPerfil=" + idPerfil + ", alumnoidAlumno=" + alumnoidAlumno + " ]";
    }
    
}
