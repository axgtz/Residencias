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
@Table(name = "Alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByApellidoPaterno", query = "SELECT a FROM Alumno a WHERE a.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Alumno.findByApellidoMaterno", query = "SELECT a FROM Alumno a WHERE a.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Alumno.findByMatricula", query = "SELECT a FROM Alumno a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Alumno.findByEmail", query = "SELECT a FROM Alumno a WHERE a.email = :email")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Integer idAlumno;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Perfilpsicologico> perfilpsicologicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Rubricaevaluacion> rubricaevaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoidAlumno")
    private Collection<Visita> visitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<AlumnohasHabitacion> alumnohasHabitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoidAlumno")
    private Collection<Indisciplina> indisciplinaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<Perfilmedico> perfilmedicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnoidAlumno")
    private Collection<Horasentrada> horasentradaCollection;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Integer idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno, String matricula, String email) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.email = email;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Perfilpsicologico> getPerfilpsicologicoCollection() {
        return perfilpsicologicoCollection;
    }

    public void setPerfilpsicologicoCollection(Collection<Perfilpsicologico> perfilpsicologicoCollection) {
        this.perfilpsicologicoCollection = perfilpsicologicoCollection;
    }

    @XmlTransient
    public Collection<Rubricaevaluacion> getRubricaevaluacionCollection() {
        return rubricaevaluacionCollection;
    }

    public void setRubricaevaluacionCollection(Collection<Rubricaevaluacion> rubricaevaluacionCollection) {
        this.rubricaevaluacionCollection = rubricaevaluacionCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @XmlTransient
    public Collection<AlumnohasHabitacion> getAlumnohasHabitacionCollection() {
        return alumnohasHabitacionCollection;
    }

    public void setAlumnohasHabitacionCollection(Collection<AlumnohasHabitacion> alumnohasHabitacionCollection) {
        this.alumnohasHabitacionCollection = alumnohasHabitacionCollection;
    }

    @XmlTransient
    public Collection<Indisciplina> getIndisciplinaCollection() {
        return indisciplinaCollection;
    }

    public void setIndisciplinaCollection(Collection<Indisciplina> indisciplinaCollection) {
        this.indisciplinaCollection = indisciplinaCollection;
    }

    @XmlTransient
    public Collection<Perfilmedico> getPerfilmedicoCollection() {
        return perfilmedicoCollection;
    }

    public void setPerfilmedicoCollection(Collection<Perfilmedico> perfilmedicoCollection) {
        this.perfilmedicoCollection = perfilmedicoCollection;
    }

    @XmlTransient
    public Collection<Horasentrada> getHorasentradaCollection() {
        return horasentradaCollection;
    }

    public void setHorasentradaCollection(Collection<Horasentrada> horasentradaCollection) {
        this.horasentradaCollection = horasentradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "residencias.Alumno[ idAlumno=" + idAlumno + " ]";
    }
    
}
