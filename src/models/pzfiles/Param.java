/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pzfiles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 003-0823
 */
@Entity
@Table(name = "param", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Param.findAll", query = "SELECT p FROM Param p"),
    @NamedQuery(name = "Param.findByName", query = "SELECT p FROM Param p WHERE p.name = :name"),
    @NamedQuery(name = "Param.findByDescription", query = "SELECT p FROM Param p WHERE p.description = :description")})
public class Param implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Param() {
    }

    public Param(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Param)) {
            return false;
        }
        Param other = (Param) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.Param[ name=" + name + " ]";
    }
    
}