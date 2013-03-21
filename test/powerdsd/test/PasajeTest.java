/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.test;

import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.Test;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.modelo.Bus;
import powerdsd.modelo.Cliente;
import powerdsd.negocio.PasajeNegocio;

/**
 *
 * @author W.Wong
 */
public class PasajeTest {
    
    public PasajeTest() {
    }
    
     @Test
    // public void hello() {}
     public void RegistrarPasaje() throws SQLException {

		String dateVta = "2013-03-24";
	    java.sql.Date sqlDateVta = java.sql.Date.valueOf(dateVta);
		String dateSal = "2013-03-24";
	    java.sql.Date sqlDateSal = java.sql.Date.valueOf(dateSal);
		String dateLle = "2013-03-21";
	    java.sql.Date sqlDateLle = java.sql.Date.valueOf(dateLle);
         
         
		Cliente cl = new Cliente();
	  	cl.setDni_cliente("07460003"); 	
		Bus bs = new Bus();
	  	bs.setNu_Placa("UI-123"); 	
		Agencia ago = new Agencia();
	  	ago.setCodAgencia("0002"); 	
		Agencia agd = new Agencia();
	  	agd.setCodAgencia("0003"); 	

         
         PasajeNegocio neg = new PasajeNegocio();

        try {
            neg.insertarPasaje(002, cl, sqlDateVta, bs, 17, ago, 
                    sqlDateSal, "15:00", agd, sqlDateLle, "18:00");
            System.out.println("Pasaje registrado con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }
    
}