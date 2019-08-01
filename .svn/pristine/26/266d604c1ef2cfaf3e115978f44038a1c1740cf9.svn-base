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
import models.pzfiles.Npf;

/**
 *
 * @author 003-0823
 */
public class NpfJpaController implements Serializable {

    public NpfJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public NpfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Npf npf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(npf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Npf npf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            npf = em.merge(npf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = npf.getId();
                if (findNpf(id) == null) {
                    throw new NonexistentEntityException("The npf with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Npf npf;
            try {
                npf = em.getReference(Npf.class, id);
                npf.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The npf with id " + id + " no longer exists.", enfe);
            }
            em.remove(npf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Npf> findNpfEntities() {
        return findNpfEntities(true, -1, -1);
    }

    public List<Npf> findNpfEntities(int maxResults, int firstResult) {
        return findNpfEntities(false, maxResults, firstResult);
    }

    private List<Npf> findNpfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Npf.class));
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

    public Npf findNpf(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Npf.class, id);
        } finally {
            em.close();
        }
    }

    public int getNpfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Npf> rt = cq.from(Npf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
