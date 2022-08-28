package com.naumdeveloper.homework;

import com.naumdeveloper.homework.daoService.Dao;
import com.naumdeveloper.homework.model.Customer;
import com.naumdeveloper.homework.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class HW {
    public static void main(String[] args) {

         // Получаем фабрику менеджеров сущностей
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hw_hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                 .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Dao gr = new Dao(entityManagerFactory);

        // Открываем транзакцию
        entityManager.getTransaction().begin();



        // Подтверждаем транзакцию
        entityManager.getTransaction().commit();



        entityManager.close();
        entityManagerFactory.close();

    }
}


/*
        SessionFactory factory = new Configuration()
                .configure("hw_hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Customer university = session.get(Customer.class, 1L);
//            System.out.println(university.getStudents().get(1).getName());
 //            System.out.println(university);
            session.getTransaction().commit();
//            System.out.println(university);



//            session.beginTransaction();
//            University universityFromNamedQuery = session
//                    .createNamedQuery("withStudents", University.class)
//                    .setParameter("id", 1L)
//                    .getSingleResult();
//            Student s = session.get(Student.class, 1L);
//            session.getTransaction().commit();
//            System.out.println(s.getUniversity().getTitle());
////            System.out.println(universityFromNamedQuery);
////            System.out.println(universityFromNamedQuery.getStudents());

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}

 */
