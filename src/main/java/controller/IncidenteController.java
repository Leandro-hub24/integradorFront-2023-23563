package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import models.Cliente;
import models.Incidente;
import controller.TecnicoController;

public class IncidenteController {

public String CrearIncidente(String tipoIncidente, String descripcionIncidente, int idCliente, int idTecnico) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			Incidente incidente = new Incidente(tipoIncidente, descripcionIncidente, idCliente, idTecnico);
			session.beginTransaction();
			session.persist(incidente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente creado satisfactoriamente\n--------\n" + incidente.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar registrar incidente";
	}
	
	public String EliminarIncidente(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Incidente incidente = session.get(Incidente.class, id);
			session.remove(incidente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente ID: "+id+" eliminado del sistema\n--------\n";
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar eliminar el incidente";
	}
	
	public String ActualizarIncidente(int id, int idCli, int idTec, String tipoIncidente, String descripcionIncidente) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		TecnicoController TecnicoCont = new TecnicoController();
		
		int a;
		
		try {
			
			session.beginTransaction();
			Incidente incidente = session.get(Incidente.class, id);
			a = incidente.getIdTecnico();
			if(idTec != a) {
				incidente.setIdTecnico(idTec);
				TecnicoCont.ActTecnicoInci(a, -1);
				TecnicoCont.ActTecnicoInci(idTec, 1);
			}
			incidente.setIdCliente(idCli);		
			incidente.setTipoIncidente(tipoIncidente);
			incidente.setDescripcionIncidente(descripcionIncidente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente ID: "+id+" actualizado en el sistema\n--------\n"+incidente.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar actualizar el incidente";
	}
	
	public String LeerIncidente(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Incidente incidente = session.get(Incidente.class, id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente ID: "+id+": "+incidente.toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al intentar leer el Incidente";
	}
	
	public String ListadoIncidente() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			CriteriaQuery<Incidente> cq = session.getCriteriaBuilder().createQuery(Incidente.class);
			
			cq.from(Incidente.class);
			
			List<Incidente> incidente = session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("L I S T A   D E   I N C I D E N T E S\n----------------------------------------");
			for (Incidente u : incidente) {
				System.out.println("INCIDENTE: "+u+"\n");
				System.out.println("ID: "+u.getId()+"\n");
				System.out.println("TIPO: "+u.getTipoIncidente()+"\n");
				System.out.println("DESCRIPCIÓN: "+u.getDescripcionIncidente()+"\n----------------------------------------");
			}
			
			sessionFactory.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Error al intentar leer la lista de incidentes";
		}
		
		return "Fin de listado de incidentes";
		
	}
	
public List<Incidente> ListadoIncidentes() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		List <Incidente> incidente1 = new ArrayList<Incidente>();
		try {
			
			session.beginTransaction();
			
			CriteriaQuery <Incidente> cq = session.getCriteriaBuilder().createQuery(Incidente.class);
			
			cq.from(Incidente.class);
			
			List <Incidente> incidente = session.createQuery(cq).getResultList();
		
			for (Incidente u : incidente) {
				incidente1.add(new Incidente(u.getId(), u.getTipoIncidente(), u.getDescripcionIncidente(), u.getIdCliente(), u.getIdTecnico()));
				}
		
			sessionFactory.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	return incidente1;
	}
}
