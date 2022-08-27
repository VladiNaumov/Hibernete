package com.naumdeveloper.homework.version2;

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
