package powerdsd.modelo;

/**
 *
 * @author u05521
 */
public class Agencia {
    
        private String codAgencia;
	private String descripcion;
	private String direccion;
	private String departamento;
	private String provincia;
	private String distrito;

    /**
     * @return the codAgencia
     */
    public String getCodAgencia() {
        return codAgencia;
    }

    /**
     * @param codAgencia the codAgencia to set
     */
    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    public Agencia(){
		
	}	
}
