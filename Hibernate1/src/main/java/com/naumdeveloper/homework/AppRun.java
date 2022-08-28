package com.naumdeveloper.homework;


import com.naumdeveloper.homework.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

/*
Задание
1. Создайте сущность Product (Long id, String title, int price) и таблицу в базе данных для хранения объектов этой сущности;
2. Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций над сущностью Product (Product findById(Long id), List<Product> findAll(), void deleteById(Long id), Product saveOrUpdate(Product product));
3. * Вшить ProductDao в веб-проект, и показывать товары, лежащие в базе данных. Помните что в таком случае SessionFactory или обертку над ней надо будет делать в виде Spring бина.
Дополнительные материалы
 */
public class AppRun {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = new Configuration()
                // передача файла конфигурации Hibernate
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        // Из фабрики создаем EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        DaoGrud daoGrud = new DaoGrud(entityManagerFactory);
        try {

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
