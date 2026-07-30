package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Department obj = new Department(1, "Books");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("======= TESTE 1: Seller findById ========\n");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("======= TESTE 2: Seller findByDepartment ========\n");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for(Seller sellerList : sellers) {
			System.out.println(sellerList);
		}
		
		System.out.println("\n======= TESTE 3: Seller findAll ========\n");
		sellers = sellerDao.findAll();
		for(Seller sellerList : sellers) {
			System.out.println(sellerList);
		}
		
		System.out.println("\n======= TESTE 4: Seller insert ========\n");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("\n======= TESTE 5: Seller update ========\n");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Seller");
		
		System.out.println("\n======= TESTE 6: Seller delete ========\n");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete seller");
		
		sc.close();
	}

}
