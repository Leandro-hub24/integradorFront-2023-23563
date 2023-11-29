package vistas;

import controller.ServicioController;

public class ServicioVista {

	public static void main(String[] args) {
		
		ServicioController ServicioCont = new ServicioController();
		
		String servicioLista = ServicioCont.ListadoServicio();
		
		System.out.println("---------------------------\n"+ servicioLista);
		
		System.out.println(servicioLista.toString());
		
		ServicioCont.CrearServicio("Office");
	}
}
