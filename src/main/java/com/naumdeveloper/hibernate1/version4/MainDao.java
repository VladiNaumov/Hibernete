package com.naumdeveloper.hibernate1.version4;

import com.naumdeveloper.hibernate1.version4.model.User;
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

        DaoRepository daoRepository = new DaoRepository(entityManagerFactory);


        daoRepository.findAll();


        entityManager.close();
        entityManagerFactory.close();
    }
}
