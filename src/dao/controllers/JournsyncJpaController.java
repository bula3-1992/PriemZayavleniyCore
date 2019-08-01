/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.controllers;

import dao.controllers.exceptions.NonexistentEntityException;
import dao.factory.Factory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.pzfiles.Journsync;

/**
 *
 * @author 003-0823
 */
public class JournsyncJpaController implements Serializable {

    public JournsyncJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public JournsyncJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Journsync journsync) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(journsync);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Journsync journsync) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            journsync = em.merge(journsync);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = journsync.getId();
                if (findJournsync(id) == null) {
                    throw new NonexistentEntityException("The journsync with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Journsync journsync;
            try {
                journsync = em.getReference(Journsync.class, id);
                journsync.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The journsync with id " + id + " no longer exists.", enfe);
            }
            em.remove(journsync);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Journsync> findJournsyncEntities() {
        return findJournsyncEntities(true, -1, -1);
    }

    public List<Journsync> findJournsyncEntities(int maxResults, int firstResult) {
        return findJournsyncEntities(false, maxResults, firstResult);
    }

    private List<Journsync> findJournsyncEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Journsync.class));
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

    public Journsync findJournsync(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Journsync.class, id);
        } finally {
            em.close();
        }
    }

    public int getJournsyncCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Journsync> rt = cq.from(Journsync.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
