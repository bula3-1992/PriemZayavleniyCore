/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pzfiles;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 003-0823
 */
@Entity
@Table(name = "message_type", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MessageType.findAll", query = "SELECT m FROM MessageType m"),
    @NamedQuery(name = "MessageType.findByType", query = "SELECT m FROM MessageType m WHERE m.type = :type"),
    @NamedQuery(name = "MessageType.findByDescription", query = "SELECT m FROM MessageType m WHERE m.description = :description")})
public class MessageType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "messageType")
    private Collection<Filestore> filestoreCollection;

    public MessageType() {
    }

    public MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageType)) {
            return false;
        }
        MessageType other = (MessageType) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.MessageType[ type=" + type + " ]";
    }
    
}
