package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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
		
		System.out.println("======= TESTE 3: Seller findAll ========\n");
		sellers = sellerDao.findAll();
		for(Seller sellerList : sellers) {
			System.out.println(sellerList);
		}
	}

}
