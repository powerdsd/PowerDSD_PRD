package powerdsd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Persona;
import powerdsd.util.ConexionBD;
import powerdsd.excepcion.LoginExcepcion;


public class PersonaDAO extends BaseDAO {
	/*
	public Collection<Persona> buscarPorDocumento(String Tx_TipoDNI, String nu_DNI) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarPorDocumento(String nombre, String nu_DNI)");
		String query = "SELECT no_Persona, ap_Paterno, ap_Materno FROM Persona WHERE Tx_TipoDNI= ? and nu_DNI=?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, Tx_TipoDNI);
			stmt.setString(2, nu_DNI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setNo_Persona(rs.getString("no_Persona"));
				vo.setAp_Paterno(rs.getString("ap_Paterno"));
				vo.setAp_Materno(rs.getString("ap_Materno"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	public Collection<Persona> buscarPorDNICORREO(String Tx_email, String nu_DNI) throws DAOExcepcion {
		System.out.println("PersonaDAO: buscarPorDocumento(String nombre, String nu_DNI)");
		String query = "SELECT no_Persona, ap_Paterno, ap_Materno FROM Persona WHERE tx_e_mail= ? and nu_DNI=?";
		Collection<Persona> lista = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, Tx_email);
			stmt.setString(2, nu_DNI);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setNo_Persona(rs.getString("no_Persona"));
				vo.setAp_Paterno(rs.getString("ap_Paterno"));
				vo.setAp_Materno(rs.getString("ap_Materno"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return lista;
	}

	
 public void insertar(Persona vo) throws DAOExcepcion {
		System.out.println("PersonaDAO: insertar(Persona vo)");
		String query = "INSERT INTO Persona(co_Persona, no_Persona, ap_Paterno, ap_Materno, fl_sexo, Tx_TipoDNI, nu_DNI, nu_Celular, " +
				"fe_Nacimiento, tx_e_mail, tx_Contrasena, nu_TipoPersona) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getCo_Persona());
			stmt.setString(2, vo.getNo_Persona());
			stmt.setString(3, vo.getAp_Paterno());
			stmt.setString(4, vo.getAp_Materno());
			stmt.setBoolean(5, vo.isFl_sexo());
			stmt.setString(6, vo.getTx_TipoDNI());
			stmt.setString(7, vo.getNu_DNI());
			stmt.setInt(8, vo.getNu_Celular());
			stmt.setDate(9, (Date) vo.getFe_Nacimiento());
			stmt.setString(10, vo.getTx_email());
			stmt.setString(11, vo.getTx_Contrasena());
			stmt.setInt(12, vo.getNu_TipoPersona());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Persona obtener(String Tx_TipoDNI, String nu_DNI) throws DAOExcepcion {
		System.out.println("PersonaDAO: obtener(String Tx_TipoDNI, String nu_DNI)");
		Persona vo = new Persona();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "Select no_Persona, ap_Paterno, ap_Materno FROM Persona WHERE Tx_TipoDNI= ? and nu_DNI=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, Tx_TipoDNI);
			stmt.setString(1, nu_DNI);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setNo_Persona(rs.getString(1));
				vo.setAp_Paterno(rs.getString(2));
				vo.setAp_Materno(rs.getString(3));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	//  public void eliminar(String rolNombre) throws DAOExcepcion {
	//	System.out.println("RolDAO: eliminar(String rolNombre)");
	//	String query = "DELETE FROM rol WHERE rol_nombre=?";
	//	Connection con = null;
	//	PreparedStatement stmt = null;
	//	try {
	//		con = ConexionBD.obtenerConexion();
	//		stmt = con.prepareStatement(query);
	//		stmt.setString(1, rolNombre);
	//		int i = stmt.executeUpdate();
	//		if (i != 1) {
	//			throw new SQLException("No se pudo eliminar");
	//		}
	//	} catch (SQLException e) {
	//		System.err.println(e.getMessage());
	//		throw new DAOExcepcion(e.getMessage());
	//	} finally {
	//		this.cerrarStatement(stmt);
	//		this.cerrarConexion(con);
	//	}
	//	}    


	public void actualizar(Persona vo) throws DAOExcepcion {
		System.out.println("PersonaDAO: actualizar(Persona vo)");
		String query = "update Persona set no_Persona=?, ap_Paterno=?, ap_Materno=?, fl_sexo=?, Tx_TipoDNI=?, nu_DNI=?, nu_Celular=?, " +
				"fe_Nacimiento=?, tx_e_mail=?, tx_Contrasena=?, nu_TipoPersona=?  where co_Persona=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNo_Persona());
			stmt.setString(2, vo.getAp_Paterno());
			stmt.setString(3, vo.getAp_Materno());
			stmt.setBoolean(4, vo.isFl_sexo());
			stmt.setString(5, vo.getTx_TipoDNI());
			stmt.setString(6, vo.getNu_DNI());
			stmt.setInt(7, vo.getNu_Celular());
			stmt.setDate(8, (Date) vo.getFe_Nacimiento());
			stmt.setString(9, vo.getTx_email());
			stmt.setString(10, vo.getTx_Contrasena());
			stmt.setInt(11, vo.getNu_TipoPersona());
			stmt.setInt(12, vo.getCo_Persona());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
	
	public Collection<Persona> listar() throws DAOExcepcion {
		System.out.println("PersonaDAO: listar()");
		Collection<Persona> c = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT co_Persona, no_Persona, ap_Paterno, ap_Materno, fl_sexo, Tx_TipoDNI, nu_DNI, nu_Celular, fe_Nacimiento, tx_e_mail, tx_Contrasena, nu_TipoPersona from Persona";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Persona vo = new Persona();
				vo.setCo_Persona(rs.getInt("co_Persona"));
				vo.setNo_Persona(rs.getString("no_Persona"));
				vo.setAp_Paterno(rs.getString("ap_Paterno"));
				vo.setAp_Materno(rs.getString("ap_Materno"));
				vo.setFl_sexo(rs.getBoolean("fl_sexo"));
				vo.setTx_TipoDNI(rs.getString("Tx_TipoDNI"));
				vo.setNu_DNI(rs.getString("nu_DNI"));
				vo.setNu_Celular(rs.getInt("nu_Celular"));
				vo.setFe_Nacimiento(rs.getDate("fe_Nacimiento"));
				vo.setTx_email(rs.getString("tx_e_mail"));
				vo.setTx_Contrasena(rs.getString("tx_Contrasena"));
				vo.setNu_TipoPersona(rs.getInt("nu_TipoPersona"));
				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}

	*/
	
	public Persona validar(String idUsuario, String clave)
			throws DAOExcepcion, LoginExcepcion {
		/*String query = "select co_Persona, no_Persona, ap_Paterno, ap_Materno, fl_sexo, Tx_TipoDNI, nu_DNI, nu_Celular, fe_Nacimiento, tx_e_mail, tx_Contrasena, nu_TipoPersona from Persona where tx_e_mail=? and tx_Contrasena=?";*/
                String query = "select no_Persona, ap_Paterno, tx_e_mail, tx_Contrasena, nu_Tipo from tb_usuarios where tx_e_mail=? and tx_Contrasena=?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona vo = new Persona();
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, idUsuario);
			stmt.setString(2, clave);
			rs = stmt.executeQuery();

			if (rs.next()) {
				/* vo.setCo_Persona(rs.getInt("co_Persona"));
				
				vo.setAp_Materno(rs.getString("ap_Materno"));
				vo.setFl_sexo(rs.getBoolean("fl_sexo"));
				vo.setTx_TipoDNI(rs.getString("Tx_TipoDNI"));
				vo.setNu_DNI(rs.getString("nu_DNI"));
				vo.setNu_Celular(rs.getInt("nu_Celular"));
				vo.setFe_Nacimiento(rs.getDate("fe_Nacimiento")); 
                                */
                                vo.setno_Persona(rs.getString("no_Persona"));
				vo.setap_Paterno(rs.getString("ap_Paterno"));
				vo.setTx_email(rs.getString("tx_e_mail"));
				vo.setTx_Contrasena(rs.getString("tx_contrasena"));
				vo.setNu_Tipo(rs.getInt("nu_tipo"));
			} else {
				throw new LoginExcepcion("No existe");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}	
	

}
