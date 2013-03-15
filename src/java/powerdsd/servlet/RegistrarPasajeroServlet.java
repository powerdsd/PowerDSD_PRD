/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import powerdsd.modelo.Cliente;
import powerdsd.negocio.AgenciaNegocio;
import powerdsd.negocio.BusNegocio;
import powerdsd.negocio.PasajeNegocio;

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
        
       // 	HttpSession sesion = request.getSession();		

                PasajeNegocio psjNeg = new PasajeNegocio();
                
		//recibo la data
		String codAgeOrigen     = request.getParameter("codAgeOrigen");
		String codAgeDestino    = request.getParameter("codAgeDestino");
		String nu_Placa         = request.getParameter("nu_Placa");
		String cboTipDni        = request.getParameter("cboTipDni");
		String txtNumDoc        = request.getParameter("txtNumDoc");
		String txtBoleto        = request.getParameter("txtBoleto");
		String txtAsiento       = request.getParameter("txtAsiento");
		String txtFechaEmision  = request.getParameter("txtFechaEmision");
		String txtFechaPartida  = request.getParameter("txtFechaPartida");
		String txtHoraPartida   = request.getParameter("txtHoraPartida");
		String txtFechaLlegada  = request.getParameter("txtFechaLlegada");
		String txtHoraLlegada   = request.getParameter("txtHoraLlegada");
                
                String dateVta = txtFechaEmision;
                java.sql.Date sqlDateVta = java.sql.Date.valueOf(dateVta);
		String dateSal = txtFechaPartida;
                java.sql.Date sqlDateSal = java.sql.Date.valueOf(dateSal);
		String dateLle = txtFechaLlegada;
                java.sql.Date sqlDateLle = java.sql.Date.valueOf(dateLle);
                
                int numAsiento = Integer.parseInt(txtAsiento);
                int numBoleto = Integer.parseInt(txtBoleto);
                
                Cliente cl = new Cliente();
		cl.setDni_cliente(txtNumDoc);
                Bus bs = new Bus();
                bs.setNu_Placa(nu_Placa);
                Agencia ago = new Agencia();
                ago.setCodAgencia(codAgeOrigen);
                Agencia agd = new Agencia();
                agd.setCodAgencia(codAgeDestino);
                try {
                    psjNeg.insertarPasaje(numBoleto, cl, sqlDateVta, bs, 
                numAsiento, ago, sqlDateVta, txtHoraPartida, 
                agd, sqlDateVta, txtHoraLlegada);
                System.out.println("se envió insertarPasaje");
     		request.setAttribute("MSG_ERROR", "El pasaje se registro con exito");
		System.out.println("despues de resquest");	
		} catch (DAOExcepcion e) {
			
			// TODO Auto-generated catch block
			//e.printStackTrace();
                    System.out.println("dentro del Catch Dao");	
			request.setAttribute("MSG_ERROR", e.getMessage()); 
		} catch (SQLException ex) {
                    System.out.println("dentro del Catch Sql");	
			request.setAttribute("MSG_ERROR", ex.getMessage()); 
        }
                                                         
    	RequestDispatcher rd = request.getRequestDispatcher("RegistrarPasajeros.jsp");
    	// Forward llama al jsp	
	rd.forward(request, response);
        
//        processRequest(request, response); linea original
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
