package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- TEST 1: departmentfindById");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("--- TEST 2: DepartmentAllId");
        List<Department> list = departmentDao.findAll();

        for (Department obj : list) {
            System.out.println(obj);

        }

        System.out.println("\n=== TEST 3: department insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());


        System.out.println("\n=== TEST 4: department update =====");
        department = departmentDao.findById(3);
        department.setName("Martha waine");
        departmentDao.update(department);
        System.out.println("update complete");

        System.out.println("\n=== TEST 5: department delete =====");
        System.out.println("enter id for delete:");
        int id= sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("delete complete");





    }
}