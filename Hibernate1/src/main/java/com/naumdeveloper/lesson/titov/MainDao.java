package com.naumdeveloper.lesson.titov;

import com.naumdeveloper.lesson.titov.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

/* используется EntityManager , EntityManagerFactory; */

public class MainDao {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = new Configuration()
                // передача файла конфигурации Hibernate
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            DaoCRUDRepository daoCRUDRepository = new DaoCRUDRepository(entityManagerFactory);


            /* */
            daoCRUDRepository.findAll();

            /* */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
