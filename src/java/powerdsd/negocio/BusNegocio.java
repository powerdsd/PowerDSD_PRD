/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.negocio;

import java.sql.SQLException;
import powerdsd.dao.BusDAO;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Bus;

/**
 *
 * @author WWong
 */
public class BusNegocio {
    
    	public void insertarBus(String placa, String marca, String modelo, String año)throws DAOExcepcion{
		
		BusDAO dao=new BusDAO();
		
		Bus oBus=new Bus();
		
		oBus.setNu_Placa(placa);
		oBus.setMarca(marca);
		oBus.setModelo(modelo);
                oBus.setAño(año);

	try
	{
		if(oBus.getNu_Placa().trim().length()==0){
			throw new SQLException("Debe ingresar la Placa del vehículo");
                }
                if(oBus.getMarca().trim().length()==0){
			throw new SQLException("Debe ingresar la Marca del vehículo");
                }
                if(oBus.getModelo().trim().length()==0){
			throw new SQLException("Debe ingresar el Modelo del vehículo");
                }
                if(oBus.getModelo().trim().length()==0){
			throw new SQLException("Debe ingresar el Año de Fabricación del vehículo");
                }
	//VALIDAR BUS
		if(dao.validarBus(placa)>0) {
			throw new SQLException("El vehículo con placa " + oBus.getNu_Placa() + " ya está registrado");
		}

                dao.insertar(oBus);
        	}
	catch(SQLException e)
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}		
	}
}
