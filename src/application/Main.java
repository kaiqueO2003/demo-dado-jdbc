package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST 1: sellerfindById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("--- TEST 2: sellerfindBydepartmentId");
        Department department= new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("--- TEST 3: sellerfindBydepartmentAllId");
         list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "anthony", "anthony@gmail.com", new Date(), 6000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update =====");
        seller = sellerDao.findById(1);
        seller.setName("Martha waine");
        sellerDao.update(seller);
        System.out.println("update complete");

        System.out.println("\n=== TEST 6: seller delete =====");
        System.out.println("enter id for delete:");
        int id= sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("delete complete");

    }
}