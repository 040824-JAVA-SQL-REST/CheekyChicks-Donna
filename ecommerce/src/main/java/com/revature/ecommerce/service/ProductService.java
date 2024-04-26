package com.revature.ecommerce.service;

import java.util.List;

import com.revature.ecommerce.dao.ProductDAO;
import com.revature.ecommerce.models.Product;

public class ProductService {
	private ProductDAO productDao;
	

	public ProductService(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}
// product screen logic
//	public List<Product> printProducts() {
//	List<Product> allProducts =	productDao.findall();
//	int prodNum = 1;
//		for(Product p : allProducts) {
//			System.out.print("[" + prodNum + "] ");
//			System.out.println( p.printProduct());
//			prodNum++;
//		}
//		return allProducts;
//		
//	}

	public List<Product> getAllProducts(){
		return productDao.findall();
	}
	
	public Product saveProduct(Product prod) {
		return productDao.save(prod);		
	}
	
	public boolean updateProduct(Product prod) {
		
		Product foundProd =productDao.findbyProductName(prod.getName());
		if(foundProd.equals(null)) {
		return false;
		}
		prod.setId(foundProd.getId());
		productDao.update(prod);
		return true;
	}
	public boolean isUniqueProductName(String name) {
		return productDao.findall().stream().noneMatch(prod -> prod.getName().equalsIgnoreCase(name));
		
	}
	
	public Product getProductById(String id) {
		return productDao.findByID(id);
		
	}


	
	}


