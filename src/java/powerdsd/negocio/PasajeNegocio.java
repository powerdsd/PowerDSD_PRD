/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.negocio;

import java.sql.SQLException;
import java.util.Date;
import powerdsd.dao.PasajeDAO;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.modelo.Bus;
import powerdsd.modelo.Cliente;
import powerdsd.modelo.Pasaje;

/**
 *
 * @author W.Wong
 */
public class PasajeNegocio {

    
    	//public void insertarPasaje(int num_pas, Cliente oCliente, Date fec_venta, Bus oBus, 
        public void insertarPasaje(Cliente oCliente, Date fec_venta, Bus oBus, 
                int num_asiento, Agencia oAgeOrigen, Date fec_salida, String hora_salida, 
                Agencia oAgeDestino, Date fec_llegada, String hora_llegada)throws DAOExcepcion, SQLException{
		
		PasajeDAO dao=new PasajeDAO();
		Pasaje oPasaje=new Pasaje();
		
		//oPasaje.setNum_pas(num_pas);
		oPasaje.setoCliente(oCliente);
		oPasaje.setFec_venta(fec_venta);
                oPasaje.setoBus(oBus);
                oPasaje.setNum_asiento(num_asiento);
                oPasaje.setoAgeOrigen(oAgeOrigen);
                oPasaje.setFec_salida(fec_salida);
                oPasaje.setHora_salida(hora_salida);
                oPasaje.setoAgeDestino(oAgeDestino);
                oPasaje.setFec_llegada(fec_llegada);
                oPasaje.setHora_llegada(hora_llegada);

	try
	{
                if (oPasaje.getoCliente()== null){
			throw new SQLException("Debe registrar el cliente.");
                }
                if (oPasaje.getoBus().getNu_Placa()==null){
			throw new SQLException("Debe indicar la placa del Bus.");
                }
                if (oPasaje.getNum_asiento()<=0){
			throw new SQLException("Debe indicar el número de asiento");
                }
                if (oPasaje.getoAgeOrigen().getCodAgencia()== null){
			throw new SQLException("Debe indicar la Agencia Origen.");
                }
                if (oPasaje.getoAgeDestino().getCodAgencia()== null){
			throw new SQLException("Debe indicar la Agencia Destino.");
                }
                if (oPasaje.getHora_salida().trim().length()==0){
			throw new SQLException("Debe ingresar la Hora de Salida");
                }
                if (oPasaje.getoAgeOrigen().getCodAgencia().equals(oPasaje.getoAgeDestino().getCodAgencia())) {
			throw new SQLException("Las agencias Origen y Destino deben ser diferentes.");
                }
                if (oPasaje.getHora_llegada().trim().length()==0){
			throw new SQLException("Debe ingresar la Hora de Llegada");
                }
                if (oPasaje.getFec_salida().before(oPasaje.getFec_venta())){
			throw new SQLException("La fecha de salida no puede ser anterior a la fecha de venta");
                }
                if (oPasaje.getFec_llegada().before(oPasaje.getFec_salida())){
			throw new SQLException("La fecha de llegada no puede ser anterior a la fecha de salida");
                }

                
	//VALIDAR PASAJE
                /*
		if(dao.validarPasaje(num_pas)>0) {
			throw new SQLException("El código de pasaje " + oPasaje.getNum_pas()+ " ya está registrado");
		}
                */

                dao.insertar(oPasaje);
        	}
	catch(SQLException e)
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}		
	}
/*
    public void insertarPasaje(int i, String 7461492, String 8032013, String aiE529, int i0, String 01, String 80320130, String 500, String 02, String 80320131, String 800) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/


}