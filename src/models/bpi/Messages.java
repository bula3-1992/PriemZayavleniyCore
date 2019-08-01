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
import javax.persistence.Lob;
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
@Table(name = "MESSAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByAddtype", query = "SELECT m FROM Messages m WHERE m.addtype = :addtype"),
    @NamedQuery(name = "Messages.findByComment", query = "SELECT m FROM Messages m WHERE m.comment = :comment"),
    @NamedQuery(name = "Messages.findByContainer", query = "SELECT m FROM Messages m WHERE m.container = :container"),
    @NamedQuery(name = "Messages.findByDirection", query = "SELECT m FROM Messages m WHERE m.direction = :direction"),
    @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id"),
    @NamedQuery(name = "Messages.findByMessageType", query = "SELECT m FROM Messages m WHERE m.messageType = :messageType"),
    @NamedQuery(name = "Messages.findByProviderId", query = "SELECT m FROM Messages m WHERE m.providerId = :providerId"),
    @NamedQuery(name = "Messages.findByProviderTime", query = "SELECT m FROM Messages m WHERE m.providerTime = :providerTime"),
    @NamedQuery(name = "Messages.findByReceiverId", query = "SELECT m FROM Messages m WHERE m.receiverId = :receiverId"),
    @NamedQuery(name = "Messages.findByReceiveTime", query = "SELECT m FROM Messages m WHERE m.receiveTime = :receiveTime"),
    @NamedQuery(name = "Messages.findBySenderId", query = "SELECT m FROM Messages m WHERE m.senderId = :senderId"),
    @NamedQuery(name = "Messages.findBySendTime", query = "SELECT m FROM Messages m WHERE m.sendTime = :sendTime"),
    @NamedQuery(name = "Messages.findBySignerId", query = "SELECT m FROM Messages m WHERE m.signerId = :signerId"),
    @NamedQuery(name = "Messages.findByStatus", query = "SELECT m FROM Messages m WHERE m.status = :status"),
    @NamedQuery(name = "Messages.findByTransId", query = "SELECT m FROM Messages m WHERE m.transId = :transId")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "ADDTYPE")
    private Short addtype;
    @Lob
    @Column(name = "BODY")
    private byte[] body;
    @Column(name = "COMMENT")
    private String comment;
    @Lob
    @Column(name = "COMMUNICATION_BODY")
    private byte[] communicationBody;
    @Column(name = "CONTAINER")
    private String container;
    @Column(name = "DIRECTION")
    private Short direction;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "MESSAGE_TYPE")
    private String messageType;
    @Column(name = "PROVIDER_ID")
    private Integer providerId;
    @Column(name = "PROVIDER_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date providerTime;
    @Column(name = "RECEIVER_ID")
    private Integer receiverId;
    @Column(name = "RECEIVE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    @Column(name = "SENDER_ID")
    private Integer senderId;
    @Column(name = "SEND_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Column(name = "SIGNER_ID")
    private Integer signerId;
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @Column(name = "TRANS_ID")
    private String transId;

    public Messages() {
    }

    public Messages(String id) {
        this.id = id;
    }

    public Messages(String id, String messageType, String transId) {
        this.id = id;
        this.messageType = messageType;
        this.transId = transId;
    }

    public Short getAddtype() {
        return addtype;
    }

    public void setAddtype(Short addtype) {
        this.addtype = addtype;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte[] getCommunicationBody() {
        return communicationBody;
    }

    public void setCommunicationBody(byte[] communicationBody) {
        this.communicationBody = communicationBody;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Short getDirection() {
        return direction;
    }

    public void setDirection(Short direction) {
        this.direction = direction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Date getProviderTime() {
        return providerTime;
    }

    public void setProviderTime(Date providerTime) {
        this.providerTime = providerTime;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.bpi.Messages[ id=" + id + " ]";
    }
    
}
