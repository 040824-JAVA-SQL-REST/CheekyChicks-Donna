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

	public List<Product> printProducts() {
	List<Product> allProducts =	productDao.findall();
	int prodNum = 1;
		for(Product p : allProducts) {
			System.out.print("[" + prodNum + "] ");
			System.out.println( p.printProduct());
			prodNum++;
		}
		return allProducts;
		
	}

	public void saveProduct(Product prod) {
		// TODO Auto-generated method stub
		
	}

	
	}


