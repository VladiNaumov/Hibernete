package com.naumdeveloper.homework;

import com.naumdeveloper.homework.model.Product;
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

    public List<Product> findProductAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = entityManager.createQuery("SELECT u FROM Product u", Product.class).getResultList();
        for (Product x : products) {
            System.out.println(x);
        }

        return products;

    }

    public List<Customer> findCustomerAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Customer> customers = entityManager.createQuery("SELECT u FROM Customer u", Customer.class).getResultList();
        for (Customer x : customers) {
            System.out.println(x);
        }

        return customers;

    }

    public void saveProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /* INSERT */
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public void saveCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /* INSERT */
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public Product findProductById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        product = entityManager.find(Product.class, id);
        return product;

    }

    public Customer findCustomerById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        customer = entityManager.find(Customer.class, id);
        return customer;

    }

    public void deleteProductId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    public void deleteCustomerId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }


}
