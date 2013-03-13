/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.test;

import java.util.Collection;
import powerdsd.negocio.AgenciaNegocio;
import junit.framework.Assert;
import org.junit.Test;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;



/**
 *
 * @author u05521
 */
public class AgenciaTest {
    
    public AgenciaTest() {
    }
/**    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    * 
    */
//    @Test
    // public void hello() {}
     public void RegistrarAgencia() {

        AgenciaNegocio neg = new AgenciaNegocio();

        try {
            neg.insertarAgencia("0002", "Terminal Surco", "Av. Atocongo 3134", "01", "0001", "123456");
            System.out.println("Agencia registrada con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }

        @Test
    // public void hello() {}
     public void listarAgenciasTest() {

        AgenciaNegocio neg = new AgenciaNegocio();

        try {
			Collection<Agencia> encontrados = neg.listarAgencias();			
			for (Agencia r : encontrados) {
				System.out.println(r.getDescripcion());
                        }
                } catch (DAOExcepcion e) {
			Assert.fail("Falló: " + e.getMessage());
		}
        }
}
