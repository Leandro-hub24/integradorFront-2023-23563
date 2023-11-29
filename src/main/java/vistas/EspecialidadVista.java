package vistas;

import controller.EspecialidadController;

public class EspecialidadVista {

	public static void main(String[] args) {
		
		EspecialidadController EspecialidadCont = new EspecialidadController();
		
		String especialidadLista = EspecialidadCont.ListadoEspecialidad();
		
		System.out.println("---------------------------\n"+ especialidadLista);
		
		System.out.println(especialidadLista.toString());
		
		//EspecialidadCont.CrearEspecialidad("Sistema Operativos");
	}
}
