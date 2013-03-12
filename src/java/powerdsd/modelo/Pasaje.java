/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.modelo;

import java.util.Date;

/**
 * @author W.Wong
 */
public class Pasaje {
    
        private int num_pas;
  	private Cliente oCliente;   //Un pasaje le pertenece a un Cliente
        private Date fec_venta;   //modifciar trabajo con fechas
  	private Bus oBus;           //Un pasaje le pertenece a un Bus
        private int num_asiento;
  	private Agencia oAgeOrigen; //Un pasaje le pertenece a una Agencia Origen
        private Date fec_salida;
        private String hora_salida;
  	private Agencia oAgeDestino; //Un pasaje le pertenece a una Agencia Destino
        private Date fec_llegada;
        private String hora_llegada;

public Pasaje(int num_pas, Cliente oCliente, Date fec_venta, Bus oBus, int num_asiento, 
        Agencia oAgeOrigen, Date fec_salida, String hora_salida, Agencia oAgeDestino,
        Date fec_llegada, String hora_llegada){
        super();
        
            this.num_pas = num_pas;
            this.oCliente = oCliente;
            this.fec_venta = fec_venta;
            this.oBus = oBus;
            this.num_asiento = num_asiento;
            this.oAgeOrigen = oAgeOrigen;
            this.fec_salida = fec_salida;
            this.hora_salida = hora_salida;
            this.oAgeDestino = oAgeDestino;
            this.fec_llegada = fec_llegada;
            this.hora_llegada = hora_llegada;
            
}       

    public Pasaje() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    /**
     * @return the num_pas
     */
    public int getNum_pas() {
        return num_pas;
    }

    /**
     * @param num_pas the num_pas to set
     */
    public void setNum_pas(int num_pas) {
        this.num_pas = num_pas;
    }

    /**
     * @return the oCliente
     */
    public Cliente getoCliente() {
        return oCliente;
    }

    /**
     * @param oCliente the oCliente to set
     */
    public void setoCliente(Cliente oCliente) {
        this.oCliente = oCliente;
    }

    /**
     * @return the fec_venta
     */
    public Date getFec_venta() {
        return fec_venta;
    }

    /**
     * @param fec_venta the fec_venta to set
     */
    public void setFec_venta(Date fec_venta) {
        this.fec_venta = fec_venta;
    }

    /**
     * @return the oBus
     */
    public Bus getoBus() {
        return oBus;
    }

    /**
     * @param oBus the oBus to set
     */
    public void setoBus(Bus oBus) {
        this.oBus = oBus;
    }

    /**
     * @return the num_asiento
     */
    public int getNum_asiento() {
        return num_asiento;
    }

    /**
     * @param num_asiento the num_asiento to set
     */
    public void setNum_asiento(int num_asiento) {
        this.num_asiento = num_asiento;
    }

    /**
     * @return the oAgeOrigen
     */
    public Agencia getoAgeOrigen() {
        return oAgeOrigen;
    }

    /**
     * @param oAgeOrigen the oAgeOrigen to set
     */
    public void setoAgeOrigen(Agencia oAgeOrigen) {
        this.oAgeOrigen = oAgeOrigen;
    }

    /**
     * @return the fec_salida
     */
    public Date getFec_salida() {
        return fec_salida;
    }

    /**
     * @param fec_salida the fec_salida to set
     */
    public void setFec_salida(Date fec_salida) {
        this.fec_salida = fec_salida;
    }

    /**
     * @return the hora_salida
     */
    public String getHora_salida() {
        return hora_salida;
    }

    /**
     * @param hora_salida the hora_salida to set
     */
    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * @return the oAgeDestino
     */
    public Agencia getoAgeDestino() {
        return oAgeDestino;
    }

    /**
     * @param oAgeDestino the oAgeDestino to set
     */
    public void setoAgeDestino(Agencia oAgeDestino) {
        this.oAgeDestino = oAgeDestino;
    }

    /**
     * @return the fec_llegada
     */
    public Date getFec_llegada() {
        return fec_llegada;
    }

    /**
     * @param fec_llegada the fec_llegada to set
     */
    public void setFec_llegada(Date fec_llegada) {
        this.fec_llegada = fec_llegada;
    }

    /**
     * @return the hora_llegada
     */
    public String getHora_llegada() {
        return hora_llegada;
    }

    /**
     * @param hora_llegada the hora_llegada to set
     */
    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }
        
        

}