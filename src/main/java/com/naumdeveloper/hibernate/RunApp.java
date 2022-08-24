package com.naumdeveloper.hibernate;

public class RunApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDaoInterface userDao = new ProductDao(sessionFactoryUtils);
            userDao.testCaching();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
