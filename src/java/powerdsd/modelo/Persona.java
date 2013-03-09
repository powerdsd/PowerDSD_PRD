package powerdsd.modelo;

import java.util.Date;


public class Persona {
	/*private int co_Persona;
	
	private String ap_Materno;
	private boolean fl_sexo;
	private String Tx_TipoDNI;
	private String nu_DNI;
	private int nu_Celular;
	private Date fe_Nacimiento;*/
        private String no_Persona;
	private String ap_Paterno;
	private String tx_email;
	private String tx_Contrasena;
	private int nu_Tipo;
	
        public String getno_Persona() {
		return no_Persona;
	}
	public void setno_Persona(String noPersona) {
		no_Persona = noPersona;
        }        
        public String getap_Paterno() {
		return ap_Paterno;
	}
	public void setap_Paterno(String apPaterno) {
		ap_Paterno = apPaterno;
        }
	public int getNu_Tipo() {
		return nu_Tipo;
	}
	public void setNu_Tipo(int nu_Tipo) {
		this.nu_Tipo = nu_Tipo;
	}
	public String getTx_email() {
		return tx_email;
	}
	public void setTx_email(String txEmail) {
		tx_email = txEmail;
	}
	public String getTx_Contrasena() {
		return tx_Contrasena;
	}
	public void setTx_Contrasena(String txContrasena) {
		tx_Contrasena = txContrasena;
	}
	public Persona(String txEmail, String txContrasena, int nuTipo) {
		super();
	
		tx_email = txEmail;
		tx_Contrasena = txContrasena;
		nu_Tipo=nuTipo;
	}
	
	public Persona(){
		
	}
}
