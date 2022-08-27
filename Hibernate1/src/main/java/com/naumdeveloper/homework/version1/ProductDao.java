package com.naumdeveloper.homework.version1;

import com.naumdeveloper.homework.version1.model.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDao implements ProductDaoInterface {

    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select pruduct from Product product where product.name = :name", Product.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {

            try (Session session = sessionFactoryUtils.getSession()) {
                session.beginTransaction();
                List<Product> product = session.createQuery("select u from Product u").getResultList();
                session.getTransaction().commit();
                return product;
            }

        // SELECT
//        User user = entityManager.find(User.class, 1L);

        // JPQL, HQL
//        List<User> users = entityManager.createQuery("select u from User u where u.id in (1, 2)", User.class)
//                .getResultList();
//
//        for (User userFromDb : users) {
//            System.out.println(userFromDb);
//        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }

    }

    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setName(newName);
            session.getTransaction().commit();
        }

    }

    @Override
    public void testCaching() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }

    }

    // INSERT
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1@a.com", "pass1"));
//        entityManager.persist(new User("User2", "2@a.com", "pass2"));
//        entityManager.persist(new User("User3", "3@a.com", "pass3"));
//
//        entityManager.getTransaction().commit();



    public void delete(){
        // DELETE


    }

}
