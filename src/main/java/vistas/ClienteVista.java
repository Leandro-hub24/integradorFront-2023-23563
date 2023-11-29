package vistas;

import controller.ClienteController;

public class ClienteVista{
	
	public static void main(String[] args) {
		
		ClienteController ClienteCont = new ClienteController();
		
		String clienteLista = ClienteCont.ListadoCliente();
		
		System.out.println("---------------------------\n"+ clienteLista);
		
		System.out.println(clienteLista.toString());
		
		
		//ClienteCont.CrearCliente("Manuel", "Goméz", 73826451, "Goméz");
	}
}