/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.test;

import junit.framework.Assert;
import org.junit.Test;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.negocio.ClienteNegocio;

/**
 *
 * @author W.Wong
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    /*
     @Test
    // public void hello() {}
     public void RegistrarCliente() {

        ClienteNegocio neg = new ClienteNegocio();
        
        // Fecha de Nacimiento
        String dateNac = "1975-01-01";
        java.sql.Date sqlDateNac = java.sql.Date.valueOf(dateNac);

        try {
            neg.insertarCliente("07460006", "Chuiman", "Perez", "Jose", sqlDateNac);
            System.out.println("Cliente registrado con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }
     */
    
}
