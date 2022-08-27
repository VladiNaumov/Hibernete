package com.naumdeveloper.lesson.fisunov.version2;

import com.naumdeveloper.homework.version1.ProductDao;
import com.naumdeveloper.homework.version1.ProductDaoInterface;
import com.naumdeveloper.homework.version1.SessionFactoryUtils;

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
