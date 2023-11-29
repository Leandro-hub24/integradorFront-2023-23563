package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import controller.IncidenteController;
import controller.TecnicoController;

/**
 * Servlet implementation class EliminarIncidente
 */
public class EliminarIncidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarIncidente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IncidenteController incidenteCont = new IncidenteController();
		TecnicoController tecnicoCont = new TecnicoController();
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String  idInci = request.getParameter("idInci") ;
		String  idTec = request.getParameter("idTec") ;
		
		incidenteCont.EliminarIncidente(Integer.parseInt(idInci));
		tecnicoCont.ActTecnicoInci(Integer.parseInt(idTec),-1);
		
		pw.println("<h1>Incidente eliminado satisfactoriamente</h1>");
		pw.print("<meta http-equiv='refresh' content=5;URL='index.jsp'>");
		pw.println("<br><br><a href= 'index.jsp'>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
