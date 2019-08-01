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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.pzfiles.MessageType;

/**
 *
 * @author 003-0823
 */
public class MessageTypeJpaController implements Serializable {

    public MessageTypeJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public MessageTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MessageType messageType) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMessageType(messageType.getType()) != null) {
                throw new PreexistingEntityException("MessageType " + messageType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MessageType messageType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            messageType = em.merge(messageType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = messageType.getType();
                if (findMessageType(id) == null) {
                    throw new NonexistentEntityException("The messageType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MessageType> findMessageTypeEntities() {
        return findMessageTypeEntities(true, -1, -1);
    }

    public List<MessageType> findMessageTypeEntities(int maxResults, int firstResult) {
        return findMessageTypeEntities(false, maxResults, firstResult);
    }

    private List<MessageType> findMessageTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MessageType.class));
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

    public MessageType findMessageType(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MessageType.class, id);
        } finally {
            em.close();
        }
    }

    public int getMessageTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MessageType> rt = cq.from(MessageType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
