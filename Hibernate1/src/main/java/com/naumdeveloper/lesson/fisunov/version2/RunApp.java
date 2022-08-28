package com.naumdeveloper.lesson.fisunov.version2;

import com.naumdeveloper.homework.ProductDao;
import com.naumdeveloper.homework.ProductDaoInterface;
import com.naumdeveloper.homework.SessionFactoryUtils;

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
