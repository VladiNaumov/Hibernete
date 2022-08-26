package com.naumdeveloper.version1;

import com.naumdeveloper.version1.model.Customer;
import com.naumdeveloper.version1.model.Product;
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
        DaoGrud daoGrud = new DaoGrud(entityManagerFactory);
        try {

            /* */

            daoGrud.findCustomerAll();
            /* */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

}
