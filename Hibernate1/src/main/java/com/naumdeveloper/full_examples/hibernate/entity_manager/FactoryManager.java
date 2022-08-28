package com.naumdeveloper.full_examples.hibernate.entity_manager;

import jakarta.persistence.*;

public class FactoryManager {
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("com.flamexander.hibernate.entity_manager");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public static void close() {
        if (emFactory != null) {
            emFactory.close();
        }
    }
}
