/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.test;

import junit.framework.Assert;
import org.junit.Test;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.negocio.BusNegocio;

/**
 *
 * @author u05521
 */
public class BusTest {
    
    public BusTest() {
    }
    
/*    @BeforeClass
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
    * 
*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    // public void hello() {}
     public void RegistrarBus() {

        BusNegocio neg = new BusNegocio();

        try {
            neg.insertarBus("UI-124", "Scania", "SD001", "2005");
            System.out.println("Bus registrado con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }
    
}