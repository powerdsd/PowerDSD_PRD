/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author s7263
 */
@WebServlet(name = "DatosReniecServlet", urlPatterns = {"/DatosReniecServlet"})
public class DatosReniecServlet extends HttpServlet {
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
            out.println("<title>Servlet DatosReniecServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatosReniecServlet at " + request.getContextPath() + "</h1>");
            
            //String dni="25723525";
            String dni="2572352";
            ArrayList persona = new ArrayList();
            //out.println("Resultado:"+datosPersona(dni));
            for(int i=0;i<4;i++)
            {
                persona.add(datosPersona(dni).getAnyType().get(i));
            }
            /* if(persona.size()==1)
            {
                out.println("Desconocido");
            } 
            else
            { 
            */
            //out.println("Desconocido "+persona.size()+"<br>");
            for(int j=0;j<4;j++)
            {
                out.println(persona.get(j));
            }
            
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
        processRequest(request, response);
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

    private localhost.ArrayOfAnyType datosPersona(java.lang.String dni) {
        localhost.WSConsultaReniecSoap port = service.getWSConsultaReniecSoap();
        return port.datosPersona(dni);
    }
    
    
}
