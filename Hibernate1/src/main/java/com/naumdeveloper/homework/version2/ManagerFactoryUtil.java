package com.naumdeveloper.homework.version2;

import com.naumdeveloper.homework.version2.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

/* используется EntityManager , EntityManagerFactory; */
public class ManagerFactoryUtil {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public void init() {
        if(entityManagerFactory == null) {
            // Получаем фабрику менеджеров сущностей
            this.entityManagerFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        }
        if(entityManager == null) {
            // Из фабрики создаем EntityManager
            this.entityManager = entityManagerFactory.createEntityManager();
        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();

        }
        if (entityManager != null) {
            entityManager.close();

        }
    }
}
