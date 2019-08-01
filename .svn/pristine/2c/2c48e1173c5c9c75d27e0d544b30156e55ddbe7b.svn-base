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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "npf", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Npf.findAll", query = "SELECT n FROM Npf n"),
    @NamedQuery(name = "Npf.findById", query = "SELECT n FROM Npf n WHERE n.id = :id"),
    @NamedQuery(name = "Npf.findByName", query = "SELECT n FROM Npf n WHERE n.name = :name"),
    @NamedQuery(name = "Npf.findByInn", query = "SELECT n FROM Npf n WHERE n.inn = :inn"),
    @NamedQuery(name = "Npf.findByKpp", query = "SELECT n FROM Npf n WHERE n.kpp = :kpp"),
    @NamedQuery(name = "Npf.findByType", query = "SELECT n FROM Npf n WHERE n.type = :type")})
public class Npf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "inn")
    private String inn;
    @Column(name = "kpp")
    private String kpp;
    @Column(name = "type")
    private Integer type;

    public Npf() {
    }

    public Npf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Npf)) {
            return false;
        }
        Npf other = (Npf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.Npf[ id=" + id + " ]";
    }
    
}
