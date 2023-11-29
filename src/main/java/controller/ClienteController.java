package controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaQuery;
import models.Cliente;

public class ClienteController {
	
	public String CrearCliente(String nombre, String apellido, int cuit, String razonSocial) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			Cliente cliente = new Cliente(nombre, apellido, cuit, razonSocial);
			session.beginTransaction();
			session.persist(cliente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Cliente creado satisfactoriamente\n--------\n" + cliente.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar registrar cliente";
	}
	
	public String EliminarCliente(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, id);
			session.remove(cliente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Cliente ID: "+id+" eliminado del sistema\n--------\n";
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar eliminar el cliente";
	}
	
	public String ActualizarCliente(int id, String nombre, String apellido, int cuit, String razonSocial) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, id);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setCuit(cuit);
			cliente.setRazonSocial(razonSocial);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Cliente ID: "+id+" actualizado en el sistema\n--------\n"+cliente.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return "Error al intentar actualizar el cliente";
	}
	
	public String LeerCliente(int id) {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			Cliente cliente = session.get(Cliente.class, id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Usuario ID: "+id+": "+cliente.toString();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "Error al intentar leer el cliente";
	}
	
	public String ListadoCliente() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			session.beginTransaction();
			
			CriteriaQuery <Cliente> cq = session.getCriteriaBuilder().createQuery(Cliente.class);
			
			cq.from(Cliente.class);
			
			List <Cliente> cliente = session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("L I S T A   D E   U S U A R I O S\n----------------------------------------");
			for (Cliente u : cliente) {
				System.out.println("CLIENTE: "+u+"\n");
				System.out.println("ID: "+u.getId()+"\n");
				System.out.println("NOMBRE: "+u.getNombre()+"\n");
				System.out.println("APELLIDO: "+u.getApellido()+"\n");
				System.out.println("CUIT: "+u.getCuit()+"\n");
				System.out.println("RAZÓN SOCIAL: "+u.getRazonSocial()+"\n----------------------------------------");
			}
			
			sessionFactory.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Error al intentar leer la lista de clientes";
		}
		
		return "Fin de listado de Clientes";
		
	}
	
public List<Cliente> ListadoClientes() {
		
		SessionFactory sessionFactory = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		List <Cliente> cliente1 = new ArrayList<Cliente>();
		try {
			
			session.beginTransaction();
			
			CriteriaQuery <Cliente> cq = session.getCriteriaBuilder().createQuery(Cliente.class);
			
			cq.from(Cliente.class);
			
			List <Cliente> cliente = session.createQuery(cq).getResultList();
		
			for (Cliente u : cliente) {
				cliente1.add(new Cliente(u.getId(), u.getNombre(), u.getApellido(), u.getCuit(), u.getRazonSocial()));
				}
		
			sessionFactory.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	return cliente1;
	}

}
