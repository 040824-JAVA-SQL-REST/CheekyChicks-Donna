package com.revature.ecommerce;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.ecommerce.utilities.JavalinUtils;


public class App {
    public static void main( String[] args ) throws SQLException, IOException{
    	App app = new App();


    	new JavalinUtils().getJavalin().start(7070);
    }
}