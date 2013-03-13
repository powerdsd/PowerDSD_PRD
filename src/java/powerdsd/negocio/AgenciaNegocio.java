/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.negocio;

import java.sql.SQLException;
import java.util.Collection;
import powerdsd.dao.AgenciaDAO;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.modelo.Bus;

/**
 *
 * @author WWong
 */
public class AgenciaNegocio {
    
    	public Collection<Agencia> listarAgencias() throws DAOExcepcion {
		AgenciaDAO dao= new AgenciaDAO();		
		return dao.listarAgencias();
	}
 
    	public void insertarAgencia(String codAgencia, String descripcion, String direccion, String departamento, String provincia, String distrito)throws DAOExcepcion{
		
		AgenciaDAO dao=new AgenciaDAO();
		
		Agencia oAgencia=new Agencia();
		
		oAgencia.setCodAgencia(codAgencia);
		oAgencia.setDescripcion(descripcion);
		oAgencia.setDireccion(direccion);
                oAgencia.setDepartamento(departamento);
                oAgencia.setProvincia(provincia);
                oAgencia.setDistrito(distrito);

	try
	{
		if(oAgencia.getCodAgencia().trim().length()==0){
			throw new SQLException("Debe ingresar el código de agencia");
                }
		if(oAgencia.getDescripcion().trim().length()==0){
			throw new SQLException("Debe ingresar el nombre de agencia");
                }
		if(oAgencia.getDireccion().trim().length()==0){
			throw new SQLException("Debe ingresar la dirección de agencia");
                }
		if(oAgencia.getDepartamento().trim().length()==0){
			throw new SQLException("Debe ingresar el departamento de la agencia");
                }
		if(oAgencia.getProvincia().trim().length()==0){
			throw new SQLException("Debe ingresar la provincia de la agencia");
                }
		if(oAgencia.getDistrito().trim().length()==0){
			throw new SQLException("Debe ingresar el distrito de la agencia");
                }
	//VALIDAR AGENCIA
		if(dao.validarAgencia(codAgencia)>0) {
			throw new SQLException("El código de agencia " + oAgencia.getCodAgencia() + " ya está registrado");
		}

                dao.insertarAgencia(oAgencia);
        	}
	catch(SQLException e)
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}		
	}
}
