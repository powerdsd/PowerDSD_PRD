/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.modelo;

import java.util.Date;

/**
 * @author W.Wong
 */
public class Cliente {
    
        private String dni_cliente;
	private String ape_pat;
	private String ape_mat;
	private String nombres;
	private Date fec_nac;

        
        
    /**
     * @return the dni_cliente
     */
    public String getDni_cliente() {
        return dni_cliente;
    }

    /**
     * @param dni_cliente the dni_cliente to set
     */
    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    /**
     * @return the ape_pat
     */
    public String getApe_pat() {
        return ape_pat;
    }

    /**
     * @param ape_pat the ape_pat to set
     */
    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    /**
     * @return the ape_mat
     */
    public String getApe_mat() {
        return ape_mat;
    }

    /**
     * @param ape_mat the ape_mat to set
     */
    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the fec_nac
     */
    public Date getFec_nac() {
        return fec_nac;
    }

    /**
     * @param fec_nac the fec_nac to set
     */
    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public Cliente(){
		
	}	


}

