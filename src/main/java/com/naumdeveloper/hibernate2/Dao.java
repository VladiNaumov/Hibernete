package com.naumdeveloper.hibernate2;


import java.util.List;

public class Dao {
    private final ManagerFactoryUtil entityManager;
    private Product product;

    private Customer customer;


    public Dao() {
        this.entityManager = new ManagerFactoryUtil();
        entityManager.init();
        this.product = new Product();
        this.customer = new Customer();

    }

    public List<Product> findAll() {
        List<Product> product = entityManager
                .getEntityManager()
                .createQuery("select u from Product u", Product.class).getResultList();

        return product;

    }

    public void save(Product product) {
        /* INSERT */
        entityManager.getEntityManager().getTransaction().begin();
        entityManager.getEntityManager().persist(product);
        entityManager.getEntityManager().getTransaction().commit();
    }

    public void save(Customer customer) {
        /* INSERT */
        entityManager.getEntityManager().getTransaction().begin();
        entityManager.getEntityManager().persist(customer);
        entityManager.getEntityManager().getTransaction().commit();
    }


}
