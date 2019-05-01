/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "response")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Response.findAll", query = "SELECT r FROM Response r")
    , @NamedQuery(name = "Response.findByIdRep", query = "SELECT r FROM Response r WHERE r.idRep = :idRep")
    , @NamedQuery(name = "Response.findByReponse", query = "SELECT r FROM Response r WHERE r.reponse = :reponse")})
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rep")
    private Integer idRep;
    @Size(max = 254)
    @Column(name = "reponse")
    private String reponse;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_ques", referencedColumnName = "id_ques")
    @ManyToOne(optional = false)
    private Question idQues;

    public Response() {
    }

    public Response(Integer idRep) {
        this.idRep = idRep;
    }

    public Integer getIdRep() {
        return idRep;
    }

    public void setIdRep(Integer idRep) {
        this.idRep = idRep;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Question getIdQues() {
        return idQues;
    }

    public void setIdQues(Question idQues) {
        this.idQues = idQues;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRep != null ? idRep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Response)) {
            return false;
        }
        Response other = (Response) object;
        if ((this.idRep == null && other.idRep != null) || (this.idRep != null && !this.idRep.equals(other.idRep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Response[ idRep=" + idRep + " ]";
    }
    
}
