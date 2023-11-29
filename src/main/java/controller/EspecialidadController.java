package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import models.Especialidad;

public class EspecialidadController {

public String CrearEspecialidad(String tipoEspecialidad) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			Especialidad especialidad = new Especialidad(tipoEspecialidad);
			session.beginTransaction();
			session.persist(especialidad);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Especialidad creada satisfactoriamente\n--------\n" + especialidad.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar registrar especialidad";
	}
	
	public String EliminarEspecialidad(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Especialidad especialidad = session.get(Especialidad.class, id);
			session.remove(especialidad);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Especialidad ID: "+id+" eliminado del sistema\n--------\n";
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar eliminar la especialidad";
	}
	
	public String ActualizarEspecialidad(int id, String tipoEspecialidad) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Especialidad especialidad = session.get(Especialidad.class, id);
			especialidad.setTipo(tipoEspecialidad);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Especialidad ID: "+id+" actualizado en el sistema\n--------\n"+especialidad.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar actualizar la especialidad";
	}
	
	public String LeerEspecialidad(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Especialidad especialidad = session.get(Especialidad.class, id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Especialidad ID: "+id+": "+especialidad.toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al intentar leer la especialidad";
	}
	
	public String ListadoEspecialidad() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Especialidad.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			CriteriaQuery<Especialidad> cq = session.getCriteriaBuilder().createQuery(Especialidad.class);
			
			cq.from(Especialidad.class);
			
			List<Especialidad> especialidad = session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("L I S T A   D E   E S P E C I A L I D A D E S\n----------------------------------------");
			for (Especialidad u : especialidad) {
				System.out.println("ESPECIALIDAD: "+u+"\n");
				System.out.println("ID: "+u.getId()+"\n");
				System.out.println("TIPO: "+u.getTipo()+"\n----------------------------------------");
			}
			
			sessionFactory.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Error al intentar leer la lista de especialidades";
		}
		
		return "Fin de listado de especialidades";
		
	}
}
