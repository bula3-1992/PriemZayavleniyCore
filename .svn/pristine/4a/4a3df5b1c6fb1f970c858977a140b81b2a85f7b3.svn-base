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
import models.pzfiles.ContentFile;
import models.pzfiles.Filestore;

/**
 *
 * @author 003-0823
 */
public class ContentFileJpaController implements Serializable {

    public ContentFileJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    public ContentFileJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ContentFile contentFile) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filestore idMessage = contentFile.getIdMessage();
            if (idMessage != null) {
                idMessage = em.getReference(idMessage.getClass(), idMessage.getId());
                contentFile.setIdMessage(idMessage);
            }
            em.persist(contentFile);
            if (idMessage != null) {
                idMessage.getContentFileCollection().add(contentFile);
                idMessage = em.merge(idMessage);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ContentFile contentFile) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ContentFile persistentContentFile = em.find(ContentFile.class, contentFile.getId());
            Filestore idMessageOld = persistentContentFile.getIdMessage();
            Filestore idMessageNew = contentFile.getIdMessage();
            if (idMessageNew != null) {
                idMessageNew = em.getReference(idMessageNew.getClass(), idMessageNew.getId());
                contentFile.setIdMessage(idMessageNew);
            }
            contentFile = em.merge(contentFile);
            if (idMessageOld != null && !idMessageOld.equals(idMessageNew)) {
                idMessageOld.getContentFileCollection().remove(contentFile);
                idMessageOld = em.merge(idMessageOld);
            }
            if (idMessageNew != null && !idMessageNew.equals(idMessageOld)) {
                idMessageNew.getContentFileCollection().add(contentFile);
                idMessageNew = em.merge(idMessageNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = contentFile.getId();
                if (findContentFile(id) == null) {
                    throw new NonexistentEntityException("The contentFile with id " + id + " no longer exists.");
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
            ContentFile contentFile;
            try {
                contentFile = em.getReference(ContentFile.class, id);
                contentFile.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contentFile with id " + id + " no longer exists.", enfe);
            }
            Filestore idMessage = contentFile.getIdMessage();
            if (idMessage != null) {
                idMessage.getContentFileCollection().remove(contentFile);
                idMessage = em.merge(idMessage);
            }
            em.remove(contentFile);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ContentFile> findContentFileEntities() {
        return findContentFileEntities(true, -1, -1);
    }

    public List<ContentFile> findContentFileEntities(int maxResults, int firstResult) {
        return findContentFileEntities(false, maxResults, firstResult);
    }

    private List<ContentFile> findContentFileEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ContentFile.class));
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

    public ContentFile findContentFile(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ContentFile.class, id);
        } finally {
            em.close();
        }
    }

    public int getContentFileCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ContentFile> rt = cq.from(ContentFile.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
