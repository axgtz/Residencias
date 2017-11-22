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

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilpsicologicoPK perfilpsicologicoPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "personalidad")
    private String personalidad;
    @Basic(optional = false)
    @Lob
    @Column(name = "comportamiento")
    private String comportamiento;
    @Basic(optional = false)
    @Lob
    @Column(name = "intereses")
    private String intereses;
    @Basic(optional = false)
    @Lob
    @Column(name = "actividades")
    private String actividades;
    @Basic(optional = false)
    @Lob
    @Column(name = "antecentes")
    private String antecentes;
    @Basic(optional = false)
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

    public Perfilpsicologico(PerfilpsicologicoPK perfilpsicologicoPK, String personalidad, String comportamiento, String intereses, String actividades, String antecentes, String comentarios) {
        this.perfilpsicologicoPK = perfilpsicologicoPK;
        this.personalidad = personalidad;
        this.comportamiento = comportamiento;
        this.intereses = intereses;
        this.actividades = actividades;
        this.antecentes = antecentes;
        this.comentarios = comentarios;
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

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getAntecentes() {
        return antecentes;
    }

    public void setAntecentes(String antecentes) {
        this.antecentes = antecentes;
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
    
}
