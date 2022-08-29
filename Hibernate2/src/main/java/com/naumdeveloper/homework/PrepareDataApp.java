package com.naumdeveloper.homework;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/* накатывает конфиг на бд */
public class PrepareDataApp {
    // Вопросы: Разница между delete и remove

    public static void forcePrepareData() {
        SessionFactory factory = new Configuration()
                .configure("hw_hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.getTransaction().begin();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        forcePrepareData();
    }
}
