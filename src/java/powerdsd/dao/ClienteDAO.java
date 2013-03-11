/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Cliente;
import powerdsd.util.ConexionBD;

public class ClienteDAO extends BaseDAO {

	public void insertar(Cliente cliente)throws DAOExcepcion{
		
		String query = "";
		query +="INSERT INTO tb_cliente(dni_cliente, ape_pat, ape_mat,";
		query +="nombres, direccion, edad)";
		query +="VALUES";
		query +="(?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;

		try
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,cliente.getDni_cliente());
			stmt.setString(2,cliente.getApe_pat());
			stmt.setString(3,cliente.getApe_mat());
			stmt.setString(4,cliente.getNombres());
			stmt.setString(5,cliente.getDireccion());
			stmt.setString(6,cliente.getEdad());
			
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}			
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		}
		finally
		{			
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

    public int validarCliente(String dni_cliente) throws DAOExcepcion {
 		int intReturn=0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "";
		query +="SELECT COUNT(*) AS CANTIDAD FROM tb_cliente WHERE ";
		query +="dni_cliente=?";
		
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				
			stmt.setString(1,dni_cliente);

			rs = stmt.executeQuery();
			while (rs.next()) {
			intReturn=rs.getInt("CANTIDAD");	
			}	
			}
			catch (SQLException e)
			{
			throw new DAOExcepcion(e.getMessage());
			}
			finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
			}	
			return intReturn;
		
	}
}
