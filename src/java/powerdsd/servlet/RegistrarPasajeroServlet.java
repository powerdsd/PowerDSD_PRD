/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.modelo.Bus;
import powerdsd.negocio.AgenciaNegocio;
import powerdsd.negocio.BusNegocio;

/**
 *
 * @author u05521
 */
@WebServlet(name = "RegistrarPasajeroServlet", urlPatterns = {"/RegistrarPasajeroServlet"})
public class RegistrarPasajeroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarPasajeroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarPasajeroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AgenciaNegocio neg = new AgenciaNegocio();
        Agencia objAgeOrigen = new Agencia();
        Agencia objAgeDestino = new Agencia();
        BusNegocio neg1 = new BusNegocio();
        Bus objBus = new Bus();

            try {
		Collection<Agencia> agencias = neg.listarAgencias();			
		Collection<Bus> buses = neg1.listarBuses();			
			// Guardando datos en el scope SESSION
			HttpSession session = request.getSession();
			session.setAttribute("AGENCIAS", agencias);
                   	session.setAttribute("OBJAgeOrigen", objAgeOrigen);
                   	session.setAttribute("OBJAgeDestino", objAgeDestino);
			session.setAttribute("BUSES", buses);
                   	session.setAttribute("OBJBus", objBus);

		} 
		catch (DAOExcepcion e) { 
		request.setAttribute(
		"MSG_ERROR", e.getMessage()); 
		}  
		RequestDispatcher rd = request
			.getRequestDispatcher("RegistrarPasajeros.jsp");
		rd.forward(request, response);
		// Forward llama al jsp	
	}

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
