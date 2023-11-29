package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import controller.TecnicoController;
import controller.IncidenteController;

/**
 * Servlet implementation class AddIncidente
 */
public class AddIncidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIncidente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TecnicoController TecnicoCont = new TecnicoController();
		IncidenteController IncidenteCont = new IncidenteController();
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String tipoInci = request.getParameter("tipoInci");
		//System.out.print(nombre);
		String descripInci = (request.getParameter("descripInci"));
		String idCli = request.getParameter("idCli");
		String idTec = request.getParameter("idTec");
		
		IncidenteCont.CrearIncidente(tipoInci, descripInci, Integer.parseInt(idCli), Integer.parseInt(idTec));
		TecnicoCont.ActTecnicoInci(Integer.parseInt(idTec), 1);
		
		pw.println("<h1>Incidente agregado satisfactoriamente</h1>");
		pw.print("<meta http-equiv='refresh' content=5;URL='index.jsp'>");
		pw.println("<br><br><a href= 'index.jsp'>Home</a>");
	}
	

}
