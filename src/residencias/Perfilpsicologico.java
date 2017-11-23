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
@Table(name = "Perfil_psicologico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilpsicologico.findAll", query = "SELECT p FROM Perfilpsicologico p")
    , @NamedQuery(name = "Perfilpsicologico.findByIdPerfil", query = "SELECT p FROM Perfilpsicologico p WHERE p.perfilpsicologicoPK.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfilpsicologico.findByAlumnoidAlumno", query = "SELECT p FROM Perfilpsicologico p WHERE p.perfilpsicologicoPK.alumnoidAlumno = :alumnoidAlumno")})
public class Perfilpsicologico implements Serializable {

    @Basic(optional = false)
    @Lob
    @Column(name = "archivo")
    private byte[] archivo;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilpsicologicoPK perfilpsicologicoPK;
    @Lob
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "Alumno_idAlumno", referencedColumnName = "idAlumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Perfilpsicologico() {
    }

    public Perfilpsicologico(PerfilpsicologicoPK perfilpsicologicoPK) {
        this.perfilpsicologicoPK = perfilpsicologicoPK;
    }

    public Perfilpsicologico(PerfilpsicologicoPK perfilpsicologicoPK, byte[] archivo) {
        this.perfilpsicologicoPK = perfilpsicologicoPK;
        this.archivo = archivo;
    }

    public Perfilpsicologico(int idPerfil, int alumnoidAlumno) {
        this.perfilpsicologicoPK = new PerfilpsicologicoPK(idPerfil, alumnoidAlumno);
    }

    public PerfilpsicologicoPK getPerfilpsicologicoPK() {
        return perfilpsicologicoPK;
    }

    public void setPerfilpsicologicoPK(PerfilpsicologicoPK perfilpsicologicoPK) {
        this.perfilpsicologicoPK = perfilpsicologicoPK;
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
        hash += (perfilpsicologicoPK != null ? perfilpsicologicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilpsicologico)) {
            return false;
        }
        Perfilpsicologico other = (Perfilpsicologico) object;
        if ((this.perfilpsicologicoPK == null && other.perfilpsicologicoPK != null) || (this.perfilpsicologicoPK != null && !this.perfilpsicologicoPK.equals(other.perfilpsicologicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Perfilpsicologico[ perfilpsicologicoPK=" + perfilpsicologicoPK + " ]";
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    
}
