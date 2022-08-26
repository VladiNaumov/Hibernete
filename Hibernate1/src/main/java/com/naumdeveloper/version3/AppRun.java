package com.naumdeveloper.version3;

import com.naumdeveloper.version3.connect.ManagerFactoryUtil;
import com.naumdeveloper.version3.repository.ProductDao;

public class AppRun {

    public static void main(String[] args) {

        ManagerFactoryUtil managerFactory = new ManagerFactoryUtil();
         try {
            ProductDao productDao = new ProductDao(managerFactory);

            //productDao.save(new Product("HEROCU", 1000200.00));
            System.out.println(productDao.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managerFactory.shutdown();
        }

    }
}