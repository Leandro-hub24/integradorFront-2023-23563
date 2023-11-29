package vistas;

import controller.TecnicoController;

public class TecnicoVista {

	public static void main(String[] args) {
		
		TecnicoController TecnicoCont = new TecnicoController();
		
		String tecnicoLista = TecnicoCont.ListadoTecnico();
		
		System.out.println("---------------------------\n"+ tecnicoLista);
		
		System.out.println(tecnicoLista.toString());
		
		
		//TecnicoCont.CrearTecnico("Miguel", "Mendoza", 3);
	}
}
