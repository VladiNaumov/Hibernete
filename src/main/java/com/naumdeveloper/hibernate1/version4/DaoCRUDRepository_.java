package com.naumdeveloper.hibernate1.version4;

import com.naumdeveloper.hibernate1.version4.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

/* используется EntityManager , EntityManagerFactory; */

public class DaoCRUDRepository_ {
    EntityManagerFactory entityManagerFactory;


    public DaoCRUDRepository_(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // INSERT
        entityManager.getTransaction().begin();

        entityManager.persist(new User("User1", "1@a.com", "pass1"));
        entityManager.persist(new User("User2", "2@a.com", "pass2"));
        entityManager.persist(new User("User3", "3@a.com", "pass3"));

        entityManager.getTransaction().commit();

    }

    public void select() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // SELECT
        User user = entityManager.find(User.class, 1L);

        // JPQL, HQL
        List<User> users = entityManager.createQuery("select u from User u where u.id in (1, 2)", User.class).getResultList();

        for (User userFromDb : users) {
            System.out.println(userFromDb);
        }


    }

    public void update() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /*UPDATE*/

        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 1L);
        user.setUsername("new Username");

        entityManager.getTransaction().commit();

        /*****/
/*
        entityManager.getTransaction().begin();

        User user = new User("User2New", "2@a.com", "pass2");
        user.setId(2L);
        entityManager.merge(user);

        entityManager.getTransaction().commit();
*/
    }

    public void delet() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /*DELET*/
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, 2L);
        entityManager.remove(user);
        entityManager.createQuery("delete from User u where u.id = 3").executeUpdate();

        entityManager.getTransaction().commit();

        Object singleResult = entityManager.createNativeQuery("""
                            select u.id as userId
                            from users u
                            where u.username like '%brain%'
                """, String.class).getSingleResult();


    }

}

