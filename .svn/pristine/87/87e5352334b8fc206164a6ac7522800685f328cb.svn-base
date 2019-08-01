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
@Table(name = "direction_type", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirectionType.findAll", query = "SELECT d FROM DirectionType d"),
    @NamedQuery(name = "DirectionType.findByIdDirection", query = "SELECT d FROM DirectionType d WHERE d.idDirection = :idDirection"),
    @NamedQuery(name = "DirectionType.findByDirectionType", query = "SELECT d FROM DirectionType d WHERE d.directionType = :directionType")})
public class DirectionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_direction")
    private Integer idDirection;
    @Column(name = "direction_type")
    private String directionType;
    @OneToMany(mappedBy = "direction")
    private Collection<Filestore> filestoreCollection;

    public DirectionType() {
    }

    public DirectionType(Integer idDirection) {
        this.idDirection = idDirection;
    }

    public Integer getIdDirection() {
        return idDirection;
    }

    public void setIdDirection(Integer idDirection) {
        this.idDirection = idDirection;
    }

    public String getDirectionType() {
        return directionType;
    }

    public void setDirectionType(String directionType) {
        this.directionType = directionType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDirection != null ? idDirection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectionType)) {
            return false;
        }
        DirectionType other = (DirectionType) object;
        if ((this.idDirection == null && other.idDirection != null) || (this.idDirection != null && !this.idDirection.equals(other.idDirection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.DirectionType[ idDirection=" + idDirection + " ]";
    }
    
}
