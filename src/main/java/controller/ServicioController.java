package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import models.Servicio;

public class ServicioController {

public String CrearServicio(String nombreServicio) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			Servicio servicio = new Servicio(nombreServicio);
			session.beginTransaction();
			session.persist(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Servicio creado satisfactoriamente\n--------\n" + servicio.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar registrar servicio";
	}
	
	public String EliminarServicio(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, id);
			session.remove(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Servicio ID: "+id+" eliminado del sistema\n--------\n";
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar eliminar el servicio";
	}
	
	public String ActualizarServicio(int id, String nombreServicio) {
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, id);
			servicio.setNombreServicio(nombreServicio);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Servicio ID: "+id+" actualizado en el sistema\n--------\n"+servicio.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar actualizar el servicio";
	}
	
	public String LeerServicio(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Servicio servicio = session.get(Servicio.class, id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Servicio ID: "+id+": "+servicio.toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al intentar leer el servicio";
	}
	
	public String ListadoServicio() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			CriteriaQuery<Servicio> cq = session.getCriteriaBuilder().createQuery(Servicio.class);
			
			cq.from(Servicio.class);
			
			List<Servicio> servicio = session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("L I S T A   D E   S E R V I C I O S\n----------------------------------------");
			for (Servicio u : servicio) {
				System.out.println("SERVICIO: "+u+"\n");
				System.out.println("ID: "+u.getId()+"\n");
				System.out.println("NOMBRE: "+u.getNombreServicio()+"\n----------------------------------------");
			}
			
			sessionFactory.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Error al intentar leer la lista de servicios";
		}
		
		return "Fin de listado de Servicios";
		
	}
}
