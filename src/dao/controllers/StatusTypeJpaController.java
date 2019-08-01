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
import models.pzfiles.StatusType;

/**
 *
 * @author 003-0823
 */
public class StatusTypeJpaController implements Serializable {

    public StatusTypeJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public StatusTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(StatusType statusType) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(statusType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findStatusType(statusType.getType()) != null) {
                throw new PreexistingEntityException("StatusType " + statusType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(StatusType statusType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            statusType = em.merge(statusType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = statusType.getType();
                if (findStatusType(id) == null) {
                    throw new NonexistentEntityException("The statusType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<StatusType> findStatusTypeEntities() {
        return findStatusTypeEntities(true, -1, -1);
    }

    public List<StatusType> findStatusTypeEntities(int maxResults, int firstResult) {
        return findStatusTypeEntities(false, maxResults, firstResult);
    }

    private List<StatusType> findStatusTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(StatusType.class));
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

    public StatusType findStatusType(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(StatusType.class, id);
        } finally {
            em.close();
        }
    }

    public int getStatusTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<StatusType> rt = cq.from(StatusType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
