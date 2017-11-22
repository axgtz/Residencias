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
    , @NamedQuery(name = "Perfilmedico.findByAlumnoidAlumno", query = "SELECT p FROM Perfilmedico p WHERE p.perfilmedicoPK.alumnoidAlumno = :alumnoidAlumno")
    , @NamedQuery(name = "Perfilmedico.findByTipoSangre", query = "SELECT p FROM Perfilmedico p WHERE p.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "Perfilmedico.findBySexo", query = "SELECT p FROM Perfilmedico p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Perfilmedico.findByAltura", query = "SELECT p FROM Perfilmedico p WHERE p.altura = :altura")
    , @NamedQuery(name = "Perfilmedico.findByPeso", query = "SELECT p FROM Perfilmedico p WHERE p.peso = :peso")
    , @NamedQuery(name = "Perfilmedico.findByAlergias", query = "SELECT p FROM Perfilmedico p WHERE p.alergias = :alergias")})
public class Perfilmedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilmedicoPK perfilmedicoPK;
    @Basic(optional = false)
    @Column(name = "tipoSangre")
    private String tipoSangre;
    @Basic(optional = false)
    @Column(name = "sexo")
    private boolean sexo;
    @Basic(optional = false)
    @Column(name = "altura")
    private float altura;
    @Basic(optional = false)
    @Column(name = "peso")
    private float peso;
    @Basic(optional = false)
    @Column(name = "alergias")
    private String alergias;
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

    public Perfilmedico(PerfilmedicoPK perfilmedicoPK, String tipoSangre, boolean sexo, float altura, float peso, String alergias) {
        this.perfilmedicoPK = perfilmedicoPK;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.alergias = alergias;
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

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
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
