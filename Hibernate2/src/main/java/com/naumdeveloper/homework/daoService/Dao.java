package com.naumdeveloper.homework.daoService;
import com.naumdeveloper.homework.model.Customer;
import com.naumdeveloper.homework.model.Product;
import com.naumdeveloper.lesson.titov.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class Dao {

    private final EntityManagerFactory emFactory;

    public Dao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Optional<Customer> findById(long id) {
        return executeForEntityManager(entityManager ->
                Optional.ofNullable(entityManager.find(Customer.class, id)));
    }

    public List<Customer> findAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("findAll", Customer.class).getResultList());
    }

    public long count() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("countAll", Long.class).getSingleResult());
    }

    public void save(Customer customer) {
        executeInTransaction(entityManager -> {
            if (customer.getId()== null) {
                entityManager.persist(customer);
            } else {
                entityManager.merge(customer);
            }
        });
    }

    public void delete(long id) {
        executeInTransaction(entityManager -> entityManager.createNamedQuery("deleteById")
                .setParameter("id", id)
                .executeUpdate());
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            em.close();
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
