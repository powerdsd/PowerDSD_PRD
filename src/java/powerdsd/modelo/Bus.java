package powerdsd.modelo;

/**
 * @author WWong
 */
public class Bus {
    
        private String nu_Placa;
	private String marca;
	private String modelo;
	private String año;

    public String getNu_Placa() {
        return nu_Placa;
    }

    public void setNu_Placa(String nu_Placa) {
        this.nu_Placa = nu_Placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    public Bus(){
		
	}	
}
