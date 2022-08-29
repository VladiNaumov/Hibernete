package com.naumdeveloper.lesson.mytest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/*
EntityManager – это интерфейс, который обеспечивает основные действия, такие, как: выборка,
добавление и удаление записи, управление транзакциями т.д. В Hibernate используется наследник
EntityManager - Session.
EntityManagerFactory – это фабричный класс, который создает и управляет несколькими
экземплярами «EntityManager».
В Hibernate используется наследник EntityManagerFactory - SessionFactory.

Persistence – класс, который содержит статические методы для создания «EntityManagerFactory».
Данный класс можно рассматривать как главную входную точку в функциональность JPA, но
непосредственно он используется редко, т.к. существует множество более удобных методов работы с JPA.

EntityTransaction – интерфейс, который используется для управления транзакциями. Для каждого
«EntityManager» создается отдельный экземпляр «EntityTransaction» через метод «getTransaction».

Entity – это объекты-сущности, которые соответствуют таблицам базы данных.

Query - это интерфейс, который используется для получения записей из базы данных.

 */

public class MainHomeWork {


     public static void main(String[] args) {
         // Получаем фабрику менеджеров сущностей
         EntityManagerFactory entityManagerFactory = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(User.class)
                 .addAnnotatedClass(Contact.class)
                 .buildSessionFactory();
         // Из фабрики создаем EntityManager
         EntityManager entityManager = entityManagerFactory.createEntityManager();

         // создаем объект
         Contact mobile = new Contact(ContactType.MOBILE_PHONE, "358-044-215-9999");
         Contact email = new Contact(ContactType.HOME_EMAIL, "outlook.com");
         Contact workMobile = new Contact(ContactType.MOBILE_PHONE, "000-044-215-9999");
         Contact workEmail = new Contact(ContactType.HOME_EMAIL, "hotmail.com");

         // передаем созданные объекты в List<Contact>
         List<Contact> contactList = Arrays.asList(mobile,email,workMobile,workEmail );

         //создаем объект user
         User user = new User("user1", contactList, "pass1");

         // Открываем транзакцию
         entityManager.getTransaction().begin();

         contactList.forEach(contact -> contact.setUser(user));
         entityManager.merge(user);

         // Подтверждаем транзакцию
         entityManager.getTransaction().commit();


         entityManager.close();
         entityManagerFactory.close();


    }
}
