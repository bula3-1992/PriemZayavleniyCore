/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pzfiles;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 003-0823
 */
@Entity
@Table(name = "filestore", schema="pz_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filestore.findAll", query = "SELECT f FROM Filestore f"),
    @NamedQuery(name = "Filestore.findByAddtype", query = "SELECT f FROM Filestore f WHERE f.addtype = :addtype"),
    @NamedQuery(name = "Filestore.findByComm", query = "SELECT f FROM Filestore f WHERE f.comm = :comm"),
    @NamedQuery(name = "Filestore.findByContainer", query = "SELECT f FROM Filestore f WHERE f.container = :container"),
    @NamedQuery(name = "Filestore.findById", query = "SELECT f FROM Filestore f WHERE f.id = :id"),
    @NamedQuery(name = "Filestore.findByProviderTime", query = "SELECT f FROM Filestore f WHERE f.providerTime = :providerTime"),
    @NamedQuery(name = "Filestore.findByReceiveTime", query = "SELECT f FROM Filestore f WHERE f.receiveTime = :receiveTime"),
    @NamedQuery(name = "Filestore.findBySendTime", query = "SELECT f FROM Filestore f WHERE f.sendTime = :sendTime"),
    @NamedQuery(name = "Filestore.findBySignerId", query = "SELECT f FROM Filestore f WHERE f.signerId = :signerId"),
    @NamedQuery(name = "Filestore.findByTransId", query = "SELECT f FROM Filestore f WHERE f.transId = :transId")})
public class Filestore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "addtype")
    private Short addtype;
    @Column(name = "comm")
    private String comm;
    @Column(name = "container")
    private String container;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "provider_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date providerTime;
    @Column(name = "receive_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    @Column(name = "send_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Column(name = "signer_id")
    private Integer signerId;
    @Column(name = "trans_id")
    private String transId;
    @OneToMany(mappedBy = "idMessage")
    private Collection<ContentFile> contentFileCollection;
    @JoinColumn(name = "status", referencedColumnName = "type")
    @ManyToOne
    private StatusType status;
    @JoinColumn(name = "message_type", referencedColumnName = "type")
    @ManyToOne
    private MessageType messageType;
    @JoinColumn(name = "direction", referencedColumnName = "id_direction")
    @ManyToOne
    private DirectionType direction;
    @JoinColumn(name = "sender_id", referencedColumnName = "id_client")
    @ManyToOne
    private Client senderId;
    @JoinColumn(name = "receiver_id", referencedColumnName = "id_client")
    @ManyToOne
    private Client receiverId;
    @JoinColumn(name = "provider_id", referencedColumnName = "id_client")
    @ManyToOne
    private Client providerId;

    public Filestore() {
    }

    public Filestore(String id) {
        this.id = id;
    }

    public Short getAddtype() {
        return addtype;
    }

    public void setAddtype(Short addtype) {
        this.addtype = addtype;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getProviderTime() {
        return providerTime;
    }

    public void setProviderTime(Date providerTime) {
        this.providerTime = providerTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSignerId() {
        return signerId;
    }

    public void setSignerId(Integer signerId) {
        this.signerId = signerId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    @XmlTransient
    public Collection<ContentFile> getContentFileCollection() {
        return contentFileCollection;
    }

    public void setContentFileCollection(Collection<ContentFile> contentFileCollection) {
        this.contentFileCollection = contentFileCollection;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public Client getSenderId() {
        return senderId;
    }

    public void setSenderId(Client senderId) {
        this.senderId = senderId;
    }

    public Client getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Client receiverId) {
        this.receiverId = receiverId;
    }

    public Client getProviderId() {
        return providerId;
    }

    public void setProviderId(Client providerId) {
        this.providerId = providerId;
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
        if (!(object instanceof Filestore)) {
            return false;
        }
        Filestore other = (Filestore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.pzfiles.Filestore[ id=" + id + " ]";
    }
    
}
