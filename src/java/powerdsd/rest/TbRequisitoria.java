/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.rest;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u05521
 */
@Entity
@Table(name = "tb_requisitoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRequisitoria.findAll", query = "SELECT t FROM TbRequisitoria t"),
    @NamedQuery(name = "TbRequisitoria.findByIdReq", query = "SELECT t FROM TbRequisitoria t WHERE t.idReq = :idReq"),
    @NamedQuery(name = "TbRequisitoria.findByDniPersona", query = "SELECT t FROM TbRequisitoria t WHERE t.dniPersona = :dniPersona"),
    @NamedQuery(name = "TbRequisitoria.findByCodDelito", query = "SELECT t FROM TbRequisitoria t WHERE t.codDelito = :codDelito"),
    @NamedQuery(name = "TbRequisitoria.findByCodEstado", query = "SELECT t FROM TbRequisitoria t WHERE t.codEstado = :codEstado"),
    @NamedQuery(name = "TbRequisitoria.findByFecReq", query = "SELECT t FROM TbRequisitoria t WHERE t.fecReq = :fecReq")})
public class TbRequisitoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_req")
    private Integer idReq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni_persona")
    private String dniPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_delito")
    private String codDelito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_estado")
    private String codEstado;
    @Column(name = "fec_req")
    @Temporal(TemporalType.DATE)
    private Date fecReq;

    public TbRequisitoria() {
    }

    public TbRequisitoria(Integer idReq) {
        this.idReq = idReq;
    }

    public TbRequisitoria(Integer idReq, String dniPersona, String codDelito, String codEstado) {
        this.idReq = idReq;
        this.dniPersona = dniPersona;
        this.codDelito = codDelito;
        this.codEstado = codEstado;
    }

    public Integer getIdReq() {
        return idReq;
    }

    public void setIdReq(Integer idReq) {
        this.idReq = idReq;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getCodDelito() {
        return codDelito;
    }

    public void setCodDelito(String codDelito) {
        this.codDelito = codDelito;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public Date getFecReq() {
        return fecReq;
    }

    public void setFecReq(Date fecReq) {
        this.fecReq = fecReq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReq != null ? idReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRequisitoria)) {
            return false;
        }
        TbRequisitoria other = (TbRequisitoria) object;
        if ((this.idReq == null && other.idReq != null) || (this.idReq != null && !this.idReq.equals(other.idReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "powerdsd.rest.TbRequisitoria[ idReq=" + idReq + " ]";
    }
    
}
