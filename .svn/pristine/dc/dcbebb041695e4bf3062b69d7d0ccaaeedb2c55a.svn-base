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
@Table(name = "client_type", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientType.findAll", query = "SELECT c FROM ClientType c"),
    @NamedQuery(name = "ClientType.findByIdType", query = "SELECT c FROM ClientType c WHERE c.idType = :idType"),
    @NamedQuery(name = "ClientType.findByDescription", query = "SELECT c FROM ClientType c WHERE c.description = :description")})
public class ClientType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_type")
    private Short idType;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "clientType")
    private Collection<Client> clientCollection;

    public ClientType() {
    }

    public ClientType(Short idType) {
        this.idType = idType;
    }

    public Short getIdType() {
        return idType;
    }

    public void setIdType(Short idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientType)) {
            return false;
        }
        ClientType other = (ClientType) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.ClientType[ idType=" + idType + " ]";
    }
    
}
