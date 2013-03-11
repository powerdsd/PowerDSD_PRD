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
    
     @Test
    // public void hello() {}
     public void RegistrarCliente() {

        ClienteNegocio neg = new ClienteNegocio();

        try {
            neg.insertarCliente("a7460004", "Huamán", "Rojas", "Pedro", "Av. Javier Prado # 123", "452");
            System.out.println("Cliente registrado con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }
    
}
