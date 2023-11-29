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
 * Servlet implementation class ActIncidente
 */
public class ActIncidente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActIncidente() {
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
		String idInci = request.getParameter("idInci");
		String idCli = request.getParameter("idCli");
		String idTec = request.getParameter("idTec");
		String tipoInci = request.getParameter("tipoInci");
		String descripInci = request.getParameter("descripInci");
		
		IncidenteCont.ActualizarIncidente(Integer.parseInt(idInci),Integer.parseInt(idCli), Integer.parseInt(idTec), tipoInci, descripInci);
		
		pw.println("<h1>Incidente actualizado satisfactoriamente</h1>");
		pw.print("<meta http-equiv='refresh' content=5;URL='index.jsp'>");
		pw.println("<br><br><a href= 'index.jsp'>Home</a>");
	}

}
