package application;

import java.util.List;

import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("======= TEST 1: Department insert ========\n");
		Department newDepartment = new Department(null, "TI");
		departmentDao.insert(newDepartment);
		System.out.println("New Departement insert with  id: " + newDepartment.getId());
	
		System.out.println("\n======= TEST 2: Department update ========\n");
		newDepartment.setName("P&D");
		departmentDao.update(newDepartment);
		System.out.println("New Departement update to: " + newDepartment.getName());
		
		System.out.println("\n======= TEST 3: Department DeleteById ========\n");
		Department dep = departmentDao.findById(1);
		String nameToDelete = dep.getName();
		try {
			departmentDao.deleteById(1);
			System.out.println("Department " + nameToDelete + " has been deleted!");
		}
		catch (DbIntegrityException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("\n======= TEST 4: Department findById ========\n");
		dep = departmentDao.findById(1);
		System.out.println("Departement Id " + dep.getId() + " is " + dep.getName());
		
		System.out.println("\n======= TEST 5: Department findAll ========\n");
		List<Department>departments = departmentDao.findAll();
		for(Department departmentsfound : departments) {
			System.out.println(departmentsfound);
		}
	}

}
