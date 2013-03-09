package powerdsd.negocio;

import java.util.Collection;
import java.util.Date;

import powerdsd.dao.PersonaDAO;
import powerdsd.excepcion.DAOExcepcion;
import powerdsd.modelo.Persona;
/* import powerdsd.modelo.Evento; */
import powerdsd.excepcion.LoginExcepcion;

public class GestionPersona {
	
	/*
	public void insertarPersona(int co_Persona, String no_Persona, String ap_Paterno, String ap_Materno, Boolean fl_sexo,
			String Tx_TipoDNI, String nu_DNI, int nu_Celular, Date fe_Nacimiento, String tx_e_mail, String tx_Contrasena, 
			int nu_TipoPersona) throws DAOExcepcion {

		Persona modelo = new Persona();
		
		modelo.setCo_Persona(co_Persona);
		modelo.setNo_Persona(no_Persona);
		modelo.setAp_Paterno(ap_Paterno);
		modelo.setAp_Materno(ap_Materno);
		modelo.setFl_sexo(fl_sexo);
		modelo.setTx_TipoDNI(Tx_TipoDNI);
		modelo.setNu_DNI(nu_DNI);
		modelo.setNu_Celular(nu_Celular);
		modelo.setFe_Nacimiento(fe_Nacimiento);
		modelo.setTx_email(tx_e_mail);
		modelo.setTx_Contrasena(tx_Contrasena);
		modelo.setNu_TipoPersona(nu_TipoPersona);
		
		PersonaDAO dao = new PersonaDAO();
		
		boolean Completo;
		
		if( (no_Persona == "") || ( ap_Paterno == "") || ( ap_Materno == "") || ( Tx_TipoDNI == "")|| ( nu_DNI == "") ||( tx_e_mail == "")){
			
		
			Completo = false;
			System.out.println("Faltan Datos para Realizar el REGISTRO de Persona.");
			
			throw new DAOExcepcion("Faltan Datos para Realizar el REGISTRO de Persona.");
			
			
		}
		
		
		Collection<Persona> lista_persona = dao.buscarPorDNICORREO(tx_e_mail, nu_DNI);
		System.out.println(lista_persona.size());
		
		
		if (lista_persona.isEmpty() && (Completo=true)) {
			//throw new DAOExcepcion("No Existe la Persona.");
			
			dao.insertar(modelo);
			
			// dao.insertar(modelo);

			System.out.println("Se Grabo Correctamente Persona.");
			//throw new DAOExcepcion("Se Grabo Correctamente Persona.");
		}
		else {
			System.out.println("Ya Existe la Persona, no se grabo Persona.");
			//throw new DAOExcepcion("Ya Existe la Persona, no se grabo Persona.");
		}
	}
	*/
	public Persona validarUsuario(String idUsuario, String clave)
			throws DAOExcepcion, LoginExcepcion {
		PersonaDAO dao = new PersonaDAO();
		return dao.validar(idUsuario, clave);
	}

}
