package powerdsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Agencia;
import powerdsd.util.ConexionBD;


/**
 *
 * @author W.Wong
 */
public class AgenciaDAO extends BaseDAO {
    
	public void insertarAgencia(Agencia agencia)throws DAOExcepcion{
		
		String query = "";
		query +="INSERT INTO tb_agencia(cod_agencia, descripcion,";
                query +="direccion, departamento, provincia, distrito)";
		query +="VALUES";
		query +="(?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;

		try
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,agencia.getCodAgencia());
			stmt.setString(2,agencia.getDescripcion());
			stmt.setString(3,agencia.getDireccion());
			stmt.setString(4,agencia.getDepartamento());
			stmt.setString(5,agencia.getProvincia());
			stmt.setString(6,agencia.getDistrito());
			
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

    public int validarAgencia(String cod_agencia) throws DAOExcepcion {
 		int intReturn=0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "";
		query +="SELECT COUNT(*) AS CANTIDAD FROM tb_agencia WHERE ";
		query +="cod_agencia=?";
		
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				
			stmt.setString(1,cod_agencia);

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