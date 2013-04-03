/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.servlet;

import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.modelo.Bus;
import powerdsd.modelo.Cliente;
import powerdsd.dao.ClienteDAO;
import powerdsd.negocio.AgenciaNegocio;
import powerdsd.negocio.BusNegocio;
import powerdsd.negocio.ClienteNegocio;
import powerdsd.negocio.PasajeNegocio;
import powerdsd.rest.ClienteREST;
import powerdsd.util.Funciones;

/**
 *
 * @author u05521
 */
@WebServlet(name = "RegistrarPasajeroServlet", urlPatterns = {"/RegistrarPasajeroServlet"})
public class RegistrarPasajeroServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_52115/ServicioReniec/WSConsultaReniec.asmx.wsdl")
    private localhost.WSConsultaReniec service;

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
            request.setAttribute("REQFechaNacimiento", Funciones.fechaActualInicial());
            request.setAttribute("REQFechaEmision", Funciones.fechaActualInicial());
            request.setAttribute("REQFechaPartida", Funciones.fechaActualInicial());
            request.setAttribute("REQFechaLlegada", Funciones.fechaActualInicial());
            request.setAttribute("TXTNumDoc", "");
            request.setAttribute("TXTNombre", "");
            request.setAttribute("TXTApePaterno", "");
            request.setAttribute("TXTApeMaterno", "");
            request.setAttribute("TXTEdad", "");
            request.setAttribute("CODAgeOrigen", "");
            request.setAttribute("CODAgeDestino", "");
            request.setAttribute("NUPlaca", objBus.getNu_Placa());
            request.setAttribute("REQHoraPartida", "");
            request.setAttribute("REQHoraLlegada", "");
            request.setAttribute("TXTAsiento", "");

        } catch (DAOExcepcion e) {
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

         	HttpSession sesion = request.getSession();		

        PasajeNegocio psjNeg = new PasajeNegocio();

        //recibo la data
        String codAgeOrigen = request.getParameter("codAgeOrigen");
        String codAgeDestino = request.getParameter("codAgeDestino");
        String nu_Placa = request.getParameter("nu_Placa");
        String cboTipDni = request.getParameter("cboTipDni");
        String txtNumDoc = request.getParameter("txtNumDoc");
        String txtApePaterno = request.getParameter("txtApePaterno");
        String txtApeMaterno = request.getParameter("txtApeMaterno");
        String txtNombre = request.getParameter("txtNombre");
        String txtFechaNacimiento = request.getParameter("txtFechaNacimiento");
        String txtEdad = request.getParameter("txtEdad");
      //String txtBoleto = request.getParameter("txtBoleto");
        String txtAsiento = request.getParameter("txtAsiento");
        String txtFechaPartida = request.getParameter("txtFechaPartida");
        String txtHoraPartida = request.getParameter("txtHoraPartida");
        String txtFechaLlegada = request.getParameter("txtFechaLlegada");
        String txtHoraLlegada = request.getParameter("txtHoraLlegada");

        Cliente cl = new Cliente();
        cl.setDni_cliente(txtNumDoc);
        Bus bs = new Bus();
        bs.setNu_Placa(nu_Placa);
        Agencia ago = new Agencia();
        ago.setCodAgencia(codAgeOrigen);
        Agencia agd = new Agencia();
        agd.setCodAgencia(codAgeDestino);

        Bus objBus = (Bus) sesion.getAttribute("OBJBus");
        
        try {
            String accion = request.getParameter("hddaccion");
            System.out.println("Valor del boton: " + accion);
            System.out.println("Boton Reniec=" + request.getParameter("Reniec"));
            System.out.println("Boton Grabar=" + request.getParameter("Grabar"));

            /*  la funcion modifica las fechas a formato aaaa-mm-dd. */
            String txtFechaNa = Funciones.cambiaFormatoFecha(txtFechaNacimiento);
            String txtFechaPa = Funciones.cambiaFormatoFecha(txtFechaPartida);
            String txtFechaLl = Funciones.cambiaFormatoFecha(txtFechaLlegada);

            String dateNac = txtFechaNa;
            java.sql.Date sqlDateNac = java.sql.Date.valueOf(dateNac);

            String txtFechaEm = Funciones.fechaActualInicial();
            String dateVta = Funciones.cambiaFormatoFecha(txtFechaEm); 
            java.sql.Date sqlDateVta = java.sql.Date.valueOf(dateVta);            
            String dateSal = txtFechaPa;
            java.sql.Date sqlDateSal = java.sql.Date.valueOf(dateSal);
            String dateLle = txtFechaLl;
            java.sql.Date sqlDateLle = java.sql.Date.valueOf(dateLle);

            request.setAttribute("REQFechaNacimiento", Funciones.fechaActualInicial());
            request.setAttribute("REQFechaPartida", Funciones.fechaActualInicial());
            request.setAttribute("REQFechaLlegada", Funciones.fechaActualInicial());
            
// ****************** Inicio consulta Reniec *************************		

            if (request.getParameter("Reniec") != null) {

                System.out.println("dentro del boton Reniec");
                
                for(Object o :datosPersona(txtNumDoc).getAnyType()){
                    System.out.println(o);
                
                }
                
                List<Object> data =datosPersona(txtNumDoc).getAnyType();

                if (!data.isEmpty()) {
                    txtNumDoc = data.get(0).toString();
                    txtNombre = data.get(3).toString();
                    txtApePaterno = data.get(1).toString();
                    txtApeMaterno = data.get(2).toString();
                    txtFechaNacimiento = data.get(4).toString();
                }

                txtEdad = String.valueOf(Funciones.calcularEdad(txtFechaNacimiento));
                
                System.out.println("Fecha Nacimiento: " + txtFechaNacimiento + "Edad: "+ Funciones.calcularEdad(txtFechaNacimiento));

                request.setAttribute("TXTNumDoc", txtNumDoc);
                request.setAttribute("TXTNombre", txtNombre);
                request.setAttribute("TXTApePaterno", txtApePaterno);
                request.setAttribute("TXTApeMaterno", txtApeMaterno);
                request.setAttribute("REQFechaNacimiento", txtFechaNacimiento);
                request.setAttribute("TXTEdad", txtEdad);

            } // ****************** Fin consulta Reniec *************************	
            // ****************** Inicio Confirmar *************************		
            else if (request.getParameter("Confirmar") != null) {

            ClienteREST client=new ClienteREST();
            System.out.println(client.validaRequisitoria(txtNumDoc));
                System.out.println("dentro del boton Confirmar");

            } // ****************** Fin Confirmar  *************************
            // ****************** Inicio Rechazar *************************		
            else if (request.getParameter("Rechazar") != null) {

                System.out.println("dentro del boton Rechazar");

            } // ****************** Fin Rechazar  *************************
            else if (request.getParameter("Grabar") != null) {

                System.out.println("dentro del boton Grabar");

                txtEdad = String.valueOf(Funciones.calcularEdad(txtFechaNacimiento));               
                request.setAttribute("TXTEdad", txtEdad);

                /*
                if (txtBoleto.trim().length() == 0) {
                    throw new DAOExcepcion("Debe ingresar el # de Boleto");
                }
                */
                //int numBoleto = Integer.parseInt(txtBoleto);

                // Guardando datos en el  scope SESSION


		ClienteDAO dao=new ClienteDAO();
                ClienteNegocio neg = new ClienteNegocio();
                
                System.out.println("validarCliente: " + dao.validarCliente(txtNumDoc) );    
                if(dao.validarCliente(txtNumDoc)==0) {
                neg.insertarCliente(txtNumDoc, txtApePaterno, txtApeMaterno, txtNombre, sqlDateNac);
                }
                if (txtAsiento.trim().length() == 0) {
                    throw new DAOExcepcion("Debe ingresar el # de Asiento");
                }
                int numAsiento = Integer.parseInt(txtAsiento);

                psjNeg.insertarPasaje(cl, sqlDateVta, bs,
                        numAsiento, ago, sqlDateSal, txtHoraPartida,
                        agd, sqlDateLle, txtHoraLlegada);
                System.out.println("se envió insertarPasaje");
                request.setAttribute("MSG_ERROR", "El pasaje se registro con exito");
                System.out.println("despues de resquest");
            }
        } catch (DAOExcepcion e) {

            // TODO Auto-generated catch block
            //e.printStackTrace();

            objBus = (Bus) sesion.getAttribute("OBJBus");

            System.out.println("dentro del Catch Dao");
            request.setAttribute("MSG_ERROR", e.getMessage());
            System.out.println(e.getMessage());
          
        } catch (SQLException ex) {

            objBus = (Bus) sesion.getAttribute("OBJBus");            
            
            System.out.println("dentro del Catch Sql");
            request.setAttribute("MSG_ERROR", ex.getMessage());
            System.out.println(ex.getMessage());
            
        }
        //LAS GUARDO PARA COLOCARLAS EN LAS CAJAS RESPECTIVAS
            request.setAttribute("TXTNumDoc", txtNumDoc);
            request.setAttribute("TXTNombre", txtNombre);
            request.setAttribute("TXTApePaterno", txtApePaterno);
            request.setAttribute("TXTApeMaterno", txtApeMaterno);
            request.setAttribute("TXTEdad", txtEdad);
            request.setAttribute("REQFechaNacimiento", txtFechaNacimiento);
            request.setAttribute("REQFechaPartida", txtFechaPartida);
            request.setAttribute("REQFechaLlegada", txtFechaLlegada);
            request.setAttribute("REQHoraPartida", txtHoraPartida);
            request.setAttribute("REQHoraLlegada", txtHoraLlegada);
            request.setAttribute("TXTAsiento", txtAsiento);
		objBus = (Bus) sesion.getAttribute("OBJBus");
//          request.setAttribute("NUPlaca", objBus.setNu_Placa(nu_Placa));
        
// Forward llama al jsp	
        RequestDispatcher rd = request.getRequestDispatcher("RegistrarPasajeros.jsp");
        rd.forward(request, response);

//			System.out.println(e.getMessage());
//			sesion.setAttribute("ERROR_MSG", e.getMessage());
//			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
//			rd.forward(request, response);
        
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

    private localhost.ArrayOfAnyType datosPersona(java.lang.String dni) {
        localhost.WSConsultaReniecSoap port = service.getWSConsultaReniecSoap();
        return port.datosPersona(dni);
    }
}
