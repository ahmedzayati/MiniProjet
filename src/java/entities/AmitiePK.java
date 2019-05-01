/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SADOK
 */
@Embeddable
public class AmitiePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "use_id_user")
    private int useIdUser;
    

    public AmitiePK() {
    }

    public AmitiePK(int idUser, int useIdUser) {
        this.idUser = idUser;
        this.useIdUser = useIdUser;
        
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getUseIdUser() {
        return useIdUser;
    }

    public void setUseIdUser(int useIdUser) {
        this.useIdUser = useIdUser;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmitiePK)) {
            return false;
        }
        AmitiePK other = (AmitiePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.useIdUser != other.useIdUser) {
            return false;
        }
        
        return true;
    }

    
    
}
