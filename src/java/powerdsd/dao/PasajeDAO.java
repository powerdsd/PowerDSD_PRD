/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Pasaje;
import powerdsd.util.ConexionBD;

public class PasajeDAO extends BaseDAO {

	public void insertar(Pasaje pasaje)throws DAOExcepcion {
		
		String query = "";
		//query +="INSERT INTO tb_pasajex(num_pas, dni_cliente, fec_venta, placa, ";
                query +="INSERT INTO tb_pasajex(dni_cliente, fec_venta, placa, ";
		query +="num_asiento, age_origen, fec_salida, hora_salida, ";
		query +="age_destino, fec_llegada, hora_llegada)";
		query +="VALUES";
		//query +="(?,?,?,?,?,?,?,?,?,?,?)";
                query +="(?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;

		try
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			//stmt.setInt(1, pasaje.getNum_pas());
			stmt.setString(1, pasaje.getoCliente().getDni_cliente());
			stmt.setDate(2, (Date) pasaje.getFec_venta());
			stmt.setString(3, pasaje.getoBus().getNu_Placa());
			stmt.setInt(4, pasaje.getNum_asiento());
			stmt.setString(5, pasaje.getoAgeOrigen().getCodAgencia());
			stmt.setDate(6, (Date) pasaje.getFec_salida());
			stmt.setString(7, pasaje.getHora_salida());
			stmt.setString(8, pasaje.getoAgeDestino().getCodAgencia());
			stmt.setDate(9, (Date) pasaje.getFec_llegada());
			stmt.setString(10, pasaje.getHora_llegada());
			
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

    public int validarPasaje(int num_pas) throws DAOExcepcion {
 		int intReturn=0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "";
		query +="SELECT COUNT(*) AS CANTIDAD FROM tb_pasajex WHERE ";
		query +="num_pas=?";
		
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				
			stmt.setInt(1,num_pas);

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

/*
    public int validarPasaje(int num_pas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/ 
}
