package com.naumdeveloper.hibernate2;

import com.naumdeveloper.hibernate2.model.Customer;
import com.naumdeveloper.hibernate2.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class AppRun {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = new Configuration()
                // передача файла конфигурации Hibernate
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            DaoGrud daoGrud = new DaoGrud(entityManagerFactory);

            /* */


            /* */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

}
