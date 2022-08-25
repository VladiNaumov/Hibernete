package com.naumdeveloper.hibernate1.version3;


import com.naumdeveloper.hibernate1.version3.connect.ManagerFactoryUtil;
import com.naumdeveloper.hibernate1.version3.repository.ProductDao;

public class AppRun {

    public static void main(String[] args) {

        ManagerFactoryUtil managerFactoryUtil = new ManagerFactoryUtil();
         try {
            ProductDao productDao = new ProductDao();

            //productDao.save(new Product("HEROCU", 1000200.00));
            System.out.println(productDao.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managerFactoryUtil.shutdown();
        }

    }
}