/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pzfiles;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 003-0823
 */
@Entity
@Table(name = "journsync", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Journsync.findAll", query = "SELECT j FROM Journsync j"),
    @NamedQuery(name = "Journsync.findById", query = "SELECT j FROM Journsync j WHERE j.id = :id"),
    @NamedQuery(name = "Journsync.findBySyncSize", query = "SELECT j FROM Journsync j WHERE j.syncSize = :syncSize"),
    @NamedQuery(name = "Journsync.findBySyncTime", query = "SELECT j FROM Journsync j WHERE j.syncTime = :syncTime")})
public class Journsync implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sync_size")
    private Integer syncSize;
    @Column(name = "sync_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncTime;

    public Journsync() {
    }

    public Journsync(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSyncSize() {
        return syncSize;
    }

    public void setSyncSize(Integer syncSize) {
        this.syncSize = syncSize;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
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
        if (!(object instanceof Journsync)) {
            return false;
        }
        Journsync other = (Journsync) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.Journsync[ id=" + id + " ]";
    }
    
}
