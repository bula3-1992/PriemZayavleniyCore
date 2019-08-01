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
import models.pzfiles.Client;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.pzfiles.ClientType;

/**
 *
 * @author 003-0818
 */
public class ClientTypeJpaController implements Serializable {

    public ClientTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ClientTypeJpaController() {
        this.emf = Factory.getInstance().getPzFilesEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ClientType clientType) throws PreexistingEntityException, Exception {
        if (clientType.getClientCollection() == null) {
            clientType.setClientCollection(new ArrayList<Client>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Client> attachedClientCollection = new ArrayList<Client>();
            for (Client clientCollectionClientToAttach : clientType.getClientCollection()) {
                clientCollectionClientToAttach = em.getReference(clientCollectionClientToAttach.getClass(), clientCollectionClientToAttach.getIdClient());
                attachedClientCollection.add(clientCollectionClientToAttach);
            }
            clientType.setClientCollection(attachedClientCollection);
            em.persist(clientType);
            for (Client clientCollectionClient : clientType.getClientCollection()) {
                ClientType oldClientTypeOfClientCollectionClient = clientCollectionClient.getClientType();
                clientCollectionClient.setClientType(clientType);
                clientCollectionClient = em.merge(clientCollectionClient);
                if (oldClientTypeOfClientCollectionClient != null) {
                    oldClientTypeOfClientCollectionClient.getClientCollection().remove(clientCollectionClient);
                    oldClientTypeOfClientCollectionClient = em.merge(oldClientTypeOfClientCollectionClient);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientType(clientType.getIdType()) != null) {
                throw new PreexistingEntityException("ClientType " + clientType + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ClientType clientType) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClientType persistentClientType = em.find(ClientType.class, clientType.getIdType());
            Collection<Client> clientCollectionOld = persistentClientType.getClientCollection();
            Collection<Client> clientCollectionNew = clientType.getClientCollection();
            Collection<Client> attachedClientCollectionNew = new ArrayList<Client>();
            for (Client clientCollectionNewClientToAttach : clientCollectionNew) {
                clientCollectionNewClientToAttach = em.getReference(clientCollectionNewClientToAttach.getClass(), clientCollectionNewClientToAttach.getIdClient());
                attachedClientCollectionNew.add(clientCollectionNewClientToAttach);
            }
            clientCollectionNew = attachedClientCollectionNew;
            clientType.setClientCollection(clientCollectionNew);
            clientType = em.merge(clientType);
            for (Client clientCollectionOldClient : clientCollectionOld) {
                if (!clientCollectionNew.contains(clientCollectionOldClient)) {
                    clientCollectionOldClient.setClientType(null);
                    clientCollectionOldClient = em.merge(clientCollectionOldClient);
                }
            }
            for (Client clientCollectionNewClient : clientCollectionNew) {
                if (!clientCollectionOld.contains(clientCollectionNewClient)) {
                    ClientType oldClientTypeOfClientCollectionNewClient = clientCollectionNewClient.getClientType();
                    clientCollectionNewClient.setClientType(clientType);
                    clientCollectionNewClient = em.merge(clientCollectionNewClient);
                    if (oldClientTypeOfClientCollectionNewClient != null && !oldClientTypeOfClientCollectionNewClient.equals(clientType)) {
                        oldClientTypeOfClientCollectionNewClient.getClientCollection().remove(clientCollectionNewClient);
                        oldClientTypeOfClientCollectionNewClient = em.merge(oldClientTypeOfClientCollectionNewClient);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = clientType.getIdType();
                if (findClientType(id) == null) {
                    throw new NonexistentEntityException("The clientType with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ClientType clientType;
            try {
                clientType = em.getReference(ClientType.class, id);
                clientType.getIdType();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientType with id " + id + " no longer exists.", enfe);
            }
            Collection<Client> clientCollection = clientType.getClientCollection();
            for (Client clientCollectionClient : clientCollection) {
                clientCollectionClient.setClientType(null);
                clientCollectionClient = em.merge(clientCollectionClient);
            }
            em.remove(clientType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ClientType> findClientTypeEntities() {
        return findClientTypeEntities(true, -1, -1);
    }

    public List<ClientType> findClientTypeEntities(int maxResults, int firstResult) {
        return findClientTypeEntities(false, maxResults, firstResult);
    }

    private List<ClientType> findClientTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ClientType.class));
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

    public ClientType findClientType(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ClientType.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ClientType> rt = cq.from(ClientType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
