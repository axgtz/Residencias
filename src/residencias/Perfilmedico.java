/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burela
 */
@Entity
@Table(name = "Perfil_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilmedico.findAll", query = "SELECT p FROM Perfilmedico p")
    , @NamedQuery(name = "Perfilmedico.findByIdPerfil", query = "SELECT p FROM Perfilmedico p WHERE p.perfilmedicoPK.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfilmedico.findByAlumnoidAlumno", query = "SELECT p FROM Perfilmedico p WHERE p.perfilmedicoPK.alumnoidAlumno = :alumnoidAlumno")})
public class Perfilmedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilmedicoPK perfilmedicoPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "archivo")
    private byte[] archivo;
    @Lob
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Perfilmedico() {
    }

    public Perfilmedico(PerfilmedicoPK perfilmedicoPK) {
        this.perfilmedicoPK = perfilmedicoPK;
    }

    public Perfilmedico(PerfilmedicoPK perfilmedicoPK, byte[] archivo) {
        this.perfilmedicoPK = perfilmedicoPK;
        this.archivo = archivo;
    }

    public Perfilmedico(int idPerfil, int alumnoidAlumno) {
        this.perfilmedicoPK = new PerfilmedicoPK(idPerfil, alumnoidAlumno);
    }

    public PerfilmedicoPK getPerfilmedicoPK() {
        return perfilmedicoPK;
    }

    public void setPerfilmedicoPK(PerfilmedicoPK perfilmedicoPK) {
        this.perfilmedicoPK = perfilmedicoPK;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilmedicoPK != null ? perfilmedicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilmedico)) {
            return false;
        }
        Perfilmedico other = (Perfilmedico) object;
        if ((this.perfilmedicoPK == null && other.perfilmedicoPK != null) || (this.perfilmedicoPK != null && !this.perfilmedicoPK.equals(other.perfilmedicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Perfilmedico[ perfilmedicoPK=" + perfilmedicoPK + " ]";
    }
    
}
