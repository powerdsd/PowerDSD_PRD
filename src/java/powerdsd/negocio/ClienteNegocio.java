/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.negocio;

import java.sql.SQLException;
import java.util.Date;
import powerdsd.dao.ClienteDAO;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Cliente;

/**
 *
 * @author W.Wong
 */
public class ClienteNegocio {
    
    	public void insertarCliente(String dni_cliente, String ape_pat, String ape_mat, String nombres, Date fec_nac)throws DAOExcepcion{
		
		ClienteDAO dao=new ClienteDAO();
		
		Cliente oCliente=new Cliente();
		
		oCliente.setDni_cliente(dni_cliente);
		oCliente.setApe_pat(ape_pat);
		oCliente.setApe_mat(ape_mat);
                oCliente.setNombres(nombres);
                oCliente.setFec_nac(fec_nac);

	try
	{
		if(oCliente.getDni_cliente().trim().length()<8){
			throw new SQLException("El DNI no es válido");
                }
                if(oCliente.getApe_pat().trim().length()==0){
			throw new SQLException("Debe ingresar el apellido paterno");
                }
                if(oCliente.getApe_mat().trim().length()==0){
			throw new SQLException("Debe ingresar el apellido materno");
                }
                if(oCliente.getNombres().trim().length()==0){
			throw new SQLException("Debe ingresar los nombres del cliente");
                }
//                if(oCliente.getEdad()<=0){
//			throw new SQLException("Debe ingresar la edad del cliente");
//                }
//                if(oCliente.getDireccion().length()==0){
//			throw new SQLException("Debe ingresar la dirección del cliente");
//                }
	//VALIDAR CLIENTE
		if(dao.validarCliente(dni_cliente)>0) {
			throw new SQLException("El cliente con DNI " + oCliente.getDni_cliente()+ " ya está registrado");
		}
                
                dao.insertar(oCliente);
        	}
	catch(SQLException e)
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}		
	}
}
