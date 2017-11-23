/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residencias;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author burela
 */
public class Residencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Administración admin = new Administración();
        // admin.setVisible(true);
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ResidenciasPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Alumno> consultaAlumnos = em.createNamedQuery("Alumno.findAll", Alumno.class);
        // consultaAlumnos.setParameter("nombre", "Arturo");
        List<Alumno> lista = consultaAlumnos.getResultList();
        Alumno r = lista.get(0);
        VentanaDetalleAlumno x = new VentanaDetalleAlumno(r);
        x.setVisible(true);
        System.out.println("*************Alumnos*********");
        for (Alumno a : lista) {
            System.out.println(a.getNombre() + "," + a.getNombre());
        }
        em.close();
        System.out.println("termino");
        // Enviar mail de prueba
        EnviarMail mail = new EnviarMail();
        // mail.EnviarMail("Subject1","hola","jpgl1997@gmail.com");
    }
}
