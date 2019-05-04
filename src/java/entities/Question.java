/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SADOK
 */
@Entity
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findByIdQues", query = "SELECT q FROM Question q WHERE q.idQues = :idQues")
    , @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question"),
 @NamedQuery(name = "Question.findUserQuestion", query = "SELECT q FROM Question q WHERE q.idUser=:id")
})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ques")
    @GeneratedValue
    private Integer idQues;
    @Size(max = 254)
    @Column(name = "question")
    private String question;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @Size(max = 254)
    @Column(name = "public")
    private String pubic;
    

    public Question() {
    }

    public Question(Integer idQues) {
        this.idQues = idQues;
    }

    public Integer getIdQues() {
        return idQues;
    }

    public void setIdQues(Integer idQues) {
        this.idQues = idQues;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQues != null ? idQues.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQues == null && other.idQues != null) || (this.idQues != null && !this.idQues.equals(other.idQues))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Question[ idQues=" + idQues + " ]";
    }

    /**
     * @return the pubic
     */
    public String getPubic() {
        return pubic;
    }

    /**
     * @param pubic the pubic to set
     */
    public void setPubic(String pubic) {
        this.pubic = pubic;
    }
    
}
