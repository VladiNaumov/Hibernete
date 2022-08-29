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

        Dao dao = new Dao(entityManagerFactory);



        // Открываем транзакцию
        entityManager.getTransaction().begin();
/*
        Customer customer = entityManager.find(Customer.class, 0L);
        System.out.println(customer.getProduct().get(0).getName());
        System.out.println(customer);

 */


        // Подтверждаем транзакцию
        entityManager.getTransaction().commit();



        entityManager.close();
        entityManagerFactory.close();

    }
}
