package com.naumdeveloper.hibernate1.version1;

public class RunApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDaoInterface productDao = new ProductDao(sessionFactoryUtils);
            productDao.testCaching();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
