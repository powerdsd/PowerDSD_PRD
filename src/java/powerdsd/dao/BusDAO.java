package powerdsd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Bus;
import powerdsd.util.ConexionBD;


public class BusDAO extends BaseDAO {

	public void insertar(Bus bus)throws DAOExcepcion{
		
		String query = "";
		query +="INSERT INTO tb_bus(placa, marca, modelo, año)";
		query +="VALUES";
		query +="(?,?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;

		try
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1,bus.getNu_Placa());
			stmt.setString(2, bus.getMarca());
			stmt.setString(3,bus.getModelo());
			stmt.setString(4,bus.getAño() );
			
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

    public int validarBus(String placa) throws DAOExcepcion {
 		int intReturn=0;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String query = "";
		query +="SELECT COUNT(*) AS CANTIDAD FROM tb_bus WHERE ";
		query +="placa=?";
		
		try{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
				
			stmt.setString(1,placa);

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

	public Collection<Bus> listarBuses() throws DAOExcepcion {
		String query;
		Collection<Bus> s = new ArrayList<Bus>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			query = "select * from tb_bus";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
					
					Bus bs= new Bus();
					bs.setNu_Placa(rs.getString("placa"));
					bs.setMarca(rs.getString("marca"));
					bs.setModelo(rs.getString("modelo"));
					bs.setAño(rs.getString("año"));
					
					s.add(bs);
					
				} 
			}catch (SQLException e) {
				System.err.println(e.getMessage());
				throw new DAOExcepcion(e.getMessage());
			} finally {
				this.cerrarStatement(stmt);
				this.cerrarConexion(con);
			}
			return s;	
	}
}