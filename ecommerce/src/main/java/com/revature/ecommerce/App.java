package com.revature.ecommerce;

import java.util.Scanner;

import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.service.UserService;
import com.revature.ecommerce.utilities.Routes;

public class App 
{
    public static void main( String[] args ){
       Scanner scan = new Scanner(System.in);
       
       new Routes(new UserService(new UserDAO()),scan).navigate("/start").start();
       
       
       scan.close();
       
    }
}
