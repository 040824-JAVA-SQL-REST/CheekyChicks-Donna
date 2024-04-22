package com.revature.ecommerce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.ecommerce.dao.ProductDAO;
import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.service.UserService;
import com.revature.ecommerce.utilities.ConnectionFactory;
import com.revature.ecommerce.utilities.Routes;

public class App 
{
    public static void main( String[] args ) throws SQLException, IOException{
    	App app = new App();
       Scanner scan = new Scanner(System.in);
       User session = new User();
       new Routes(app.getUserService(),scan, session,app.getProdSrv()).navigate("/start").start();
       scan.close();
       
    }

    private UserService getUserService() {
    	return new UserService(new UserDAO());
    }
    private ProductService getProdSrv() {
    	return new ProductService(new ProductDAO());
    }
}