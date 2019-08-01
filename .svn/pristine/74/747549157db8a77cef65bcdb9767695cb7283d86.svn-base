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
import models.pzfiles.DirectionType;

/**
 *
 * @author 003-0823
 */
public class DirectionTypeJpaController implements Serializable {

    public DirectionTypeJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public DirectionTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DirectionType directionType) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(directionType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDirectionType(directionType.getIdDirection()) != null) {
                throw new PreexistingEntityException("DirectionType " + directionType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DirectionType directionType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            directionType = em.merge(directionType);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = directionType.getIdDirection();
                if (findDirectionType(id) == null) {
                    throw new NonexistentEntityException("The directionType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DirectionType> findDirectionTypeEntities() {
        return findDirectionTypeEntities(true, -1, -1);
    }

    public List<DirectionType> findDirectionTypeEntities(int maxResults, int firstResult) {
        return findDirectionTypeEntities(false, maxResults, firstResult);
    }

    private List<DirectionType> findDirectionTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DirectionType.class));
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

    public DirectionType findDirectionType(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DirectionType.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirectionTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DirectionType> rt = cq.from(DirectionType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
