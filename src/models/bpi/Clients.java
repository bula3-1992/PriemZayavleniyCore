/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.bpi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 003-0818
 */
@Entity
@Table(name = "CLIENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByCreateDate", query = "SELECT c FROM Clients c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "Clients.findByCtype", query = "SELECT c FROM Clients c WHERE c.ctype = :ctype"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByOwnerPf", query = "SELECT c FROM Clients c WHERE c.ownerPf = :ownerPf"),
    @NamedQuery(name = "Clients.findByPfNom", query = "SELECT c FROM Clients c WHERE c.pfNom = :pfNom"),
    @NamedQuery(name = "Clients.findByPhone", query = "SELECT c FROM Clients c WHERE c.phone = :phone"),
    @NamedQuery(name = "Clients.findByProviderId", query = "SELECT c FROM Clients c WHERE c.providerId = :providerId"),
    @NamedQuery(name = "Clients.findByPtksCode", query = "SELECT c FROM Clients c WHERE c.ptksCode = :ptksCode"),
    @NamedQuery(name = "Clients.findBySenderId", query = "SELECT c FROM Clients c WHERE c.senderId = :senderId"),
    @NamedQuery(name = "Clients.findBySysTime", query = "SELECT c FROM Clients c WHERE c.sysTime = :sysTime"),
    @NamedQuery(name = "Clients.findByUserId", query = "SELECT c FROM Clients c WHERE c.userId = :userId")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "CTYPE")
    private short ctype;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "OWNER_PF")
    private Integer ownerPf;
    @Column(name = "PF_NOM")
    private String pfNom;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PROVIDER_ID")
    private Integer providerId;
    @Column(name = "PTKS_CODE")
    private String ptksCode;
    @Column(name = "SENDER_ID")
    private Integer senderId;
    @Column(name = "SYS$TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysTime;
    @Column(name = "USER_ID")
    private Integer userId;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Clients(Integer id, short ctype) {
        this.id = id;
        this.ctype = ctype;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public short getCtype() {
        return ctype;
    }

    public void setCtype(short ctype) {
        this.ctype = ctype;
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

    public Integer getOwnerPf() {
        return ownerPf;
    }

    public void setOwnerPf(Integer ownerPf) {
        this.ownerPf = ownerPf;
    }

    public String getPfNom() {
        return pfNom;
    }

    public void setPfNom(String pfNom) {
        this.pfNom = pfNom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getPtksCode() {
        return ptksCode;
    }

    public void setPtksCode(String ptksCode) {
        this.ptksCode = ptksCode;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.bpi.Clients[ id=" + id + " ]";
    }
    
}
