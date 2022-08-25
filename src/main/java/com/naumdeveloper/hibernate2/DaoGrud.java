package com.naumdeveloper.hibernate2;

import com.naumdeveloper.hibernate2.model.Customer;
import com.naumdeveloper.hibernate2.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DaoGrud {
    private final EntityManagerFactory entityManagerFactory;
    private Product product;
    private Customer customer;

    public DaoGrud(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.product = new Product();
        this.customer = new Customer();

    }

    public List<Customer> findCustomerAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Customer> customers = entityManager.createQuery("select u from Customer u where ", Customer.class).getResultList();
        for (Customer x : customers) {
            System.out.println(x);
        }

        return customers;

    }

    public void save(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /* INSERT */
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /* INSERT */
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }


}
