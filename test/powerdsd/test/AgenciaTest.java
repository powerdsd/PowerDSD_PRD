/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.test;

import powerdsd.negocio.AgenciaNegocio;
import junit.framework.Assert;
import org.junit.Test;
import powerdsd.excepcion.DAOExcepcion;



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
    @Test
    // public void hello() {}
     public void RegistrarAgencia() {

        AgenciaNegocio neg = new AgenciaNegocio();

        try {
            neg.insertarAgencia("0001", "Terminal San Borja", "Av. Aviación 2401", "01", "0001", "123456");
            System.out.println("Agencia registrada con éxito.");
        } catch (DAOExcepcion e) {
            Assert.fail("Fallo: " + e.getMessage());
        }
    }
    
}