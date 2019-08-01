/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.controllers;

import dao.controllers.exceptions.NonexistentEntityException;
import dao.controllers.exceptions.PreexistingEntityException;
import dao.factory.Factory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.pzfiles.StatusType;
import models.pzfiles.MessageType;
import models.pzfiles.DirectionType;
import models.pzfiles.Client;
import models.pzfiles.ContentFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.pzfiles.Filestore;

/**
 *
 * @author 003-0823
 */
public class FilestoreJpaController implements Serializable {

    public FilestoreJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public FilestoreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Filestore filestore) throws PreexistingEntityException, Exception {
        if (filestore.getContentFileCollection() == null) {
            filestore.setContentFileCollection(new ArrayList<ContentFile>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            StatusType status = filestore.getStatus();
            if (status != null) {
                status = em.getReference(status.getClass(), status.getType());
                filestore.setStatus(status);
            }
            MessageType messageType = filestore.getMessageType();
            if (messageType != null) {
                messageType = em.getReference(messageType.getClass(), messageType.getType());
                filestore.setMessageType(messageType);
            }
            DirectionType direction = filestore.getDirection();
            if (direction != null) {
                direction = em.getReference(direction.getClass(), direction.getIdDirection());
                filestore.setDirection(direction);
            }
            Client senderId = filestore.getSenderId();
            if (senderId != null) {
                senderId = em.getReference(senderId.getClass(), senderId.getIdClient());
                filestore.setSenderId(senderId);
            }
            Client receiverId = filestore.getReceiverId();
            if (receiverId != null) {
                receiverId = em.getReference(receiverId.getClass(), receiverId.getIdClient());
                filestore.setReceiverId(receiverId);
            }
            Client providerId = filestore.getProviderId();
            if (providerId != null) {
                providerId = em.getReference(providerId.getClass(), providerId.getIdClient());
                filestore.setProviderId(providerId);
            }
            Collection<ContentFile> attachedContentFileCollection = new ArrayList<ContentFile>();
            for (ContentFile contentFileCollectionContentFileToAttach : filestore.getContentFileCollection()) {
                contentFileCollectionContentFileToAttach = em.getReference(contentFileCollectionContentFileToAttach.getClass(), contentFileCollectionContentFileToAttach.getId());
                attachedContentFileCollection.add(contentFileCollectionContentFileToAttach);
            }
            filestore.setContentFileCollection(attachedContentFileCollection);
            em.persist(filestore);
            for (ContentFile contentFileCollectionContentFile : filestore.getContentFileCollection()) {
                Filestore oldIdMessageOfContentFileCollectionContentFile = contentFileCollectionContentFile.getIdMessage();
                contentFileCollectionContentFile.setIdMessage(filestore);
                contentFileCollectionContentFile = em.merge(contentFileCollectionContentFile);
                if (oldIdMessageOfContentFileCollectionContentFile != null) {
                    oldIdMessageOfContentFileCollectionContentFile.getContentFileCollection().remove(contentFileCollectionContentFile);
                    oldIdMessageOfContentFileCollectionContentFile = em.merge(oldIdMessageOfContentFileCollectionContentFile);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFilestore(filestore.getId()) != null) {
                throw new PreexistingEntityException("Filestore " + filestore + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Filestore filestore) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filestore persistentFilestore = em.find(Filestore.class, filestore.getId());
            StatusType statusNew = filestore.getStatus();
            MessageType messageTypeNew = filestore.getMessageType();
            DirectionType directionNew = filestore.getDirection();
            Client senderIdNew = filestore.getSenderId();
            Client receiverIdNew = filestore.getReceiverId();
            Client providerIdNew = filestore.getProviderId();
            Collection<ContentFile> contentFileCollectionOld = persistentFilestore.getContentFileCollection();
            Collection<ContentFile> contentFileCollectionNew = filestore.getContentFileCollection();
            if (statusNew != null) {
                statusNew = em.getReference(statusNew.getClass(), statusNew.getType());
                filestore.setStatus(statusNew);
            }
            if (messageTypeNew != null) {
                messageTypeNew = em.getReference(messageTypeNew.getClass(), messageTypeNew.getType());
                filestore.setMessageType(messageTypeNew);
            }
            if (directionNew != null) {
                directionNew = em.getReference(directionNew.getClass(), directionNew.getIdDirection());
                filestore.setDirection(directionNew);
            }
            if (senderIdNew != null) {
                senderIdNew = em.getReference(senderIdNew.getClass(), senderIdNew.getIdClient());
                filestore.setSenderId(senderIdNew);
            }
            if (receiverIdNew != null) {
                receiverIdNew = em.getReference(receiverIdNew.getClass(), receiverIdNew.getIdClient());
                filestore.setReceiverId(receiverIdNew);
            }
            if (providerIdNew != null) {
                providerIdNew = em.getReference(providerIdNew.getClass(), providerIdNew.getIdClient());
                filestore.setProviderId(providerIdNew);
            }
            Collection<ContentFile> attachedContentFileCollectionNew = new ArrayList<ContentFile>();
            for (ContentFile contentFileCollectionNewContentFileToAttach : contentFileCollectionNew) {
                contentFileCollectionNewContentFileToAttach = em.getReference(contentFileCollectionNewContentFileToAttach.getClass(), contentFileCollectionNewContentFileToAttach.getId());
                attachedContentFileCollectionNew.add(contentFileCollectionNewContentFileToAttach);
            }
            contentFileCollectionNew = attachedContentFileCollectionNew;
            filestore.setContentFileCollection(contentFileCollectionNew);
            filestore = em.merge(filestore);
            for (ContentFile contentFileCollectionOldContentFile : contentFileCollectionOld) {
                if (!contentFileCollectionNew.contains(contentFileCollectionOldContentFile)) {
                    contentFileCollectionOldContentFile.setIdMessage(null);
                    contentFileCollectionOldContentFile = em.merge(contentFileCollectionOldContentFile);
                }
            }
            for (ContentFile contentFileCollectionNewContentFile : contentFileCollectionNew) {
                if (!contentFileCollectionOld.contains(contentFileCollectionNewContentFile)) {
                    Filestore oldIdMessageOfContentFileCollectionNewContentFile = contentFileCollectionNewContentFile.getIdMessage();
                    contentFileCollectionNewContentFile.setIdMessage(filestore);
                    contentFileCollectionNewContentFile = em.merge(contentFileCollectionNewContentFile);
                    if (oldIdMessageOfContentFileCollectionNewContentFile != null && !oldIdMessageOfContentFileCollectionNewContentFile.equals(filestore)) {
                        oldIdMessageOfContentFileCollectionNewContentFile.getContentFileCollection().remove(contentFileCollectionNewContentFile);
                        oldIdMessageOfContentFileCollectionNewContentFile = em.merge(oldIdMessageOfContentFileCollectionNewContentFile);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = filestore.getId();
                if (findFilestore(id) == null) {
                    throw new NonexistentEntityException("The filestore with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filestore filestore;
            try {
                filestore = em.getReference(Filestore.class, id);
                filestore.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The filestore with id " + id + " no longer exists.", enfe);
            }
            Collection<ContentFile> contentFileCollection = filestore.getContentFileCollection();
            for (ContentFile contentFileCollectionContentFile : contentFileCollection) {
                contentFileCollectionContentFile.setIdMessage(null);
                contentFileCollectionContentFile = em.merge(contentFileCollectionContentFile);
            }
            em.remove(filestore);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Filestore> findFilestoreEntities() {
        return findFilestoreEntities(true, -1, -1);
    }

    public List<Filestore> findFilestoreEntities(int maxResults, int firstResult) {
        return findFilestoreEntities(false, maxResults, firstResult);
    }

    private List<Filestore> findFilestoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Filestore.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Filestore findFilestore(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Filestore.class, id);
        } finally {
            em.close();
        }
    }

    public int getFilestoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Filestore> rt = cq.from(Filestore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
