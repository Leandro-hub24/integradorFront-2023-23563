package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import controller.ClienteController;

/**
 * Servlet implementation class ActCliente
 */
public class ActCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActCliente() {
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
		ClienteController ClienteCont = new ClienteController();
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String cuit = request.getParameter("cuit");
		String razon = request.getParameter("razon");
		
		ClienteCont.ActualizarCliente(Integer.parseInt(id), nombre, apellido, Integer.parseInt(cuit), razon);
		
		pw.println("<h1>Cliente actualizado satisfactoriamente</h1>");
		pw.print("<meta http-equiv='refresh' content=5;URL='index.jsp'>");
		pw.println("<br><br><a href= 'index.jsp'>Home</a>");
	}

}
