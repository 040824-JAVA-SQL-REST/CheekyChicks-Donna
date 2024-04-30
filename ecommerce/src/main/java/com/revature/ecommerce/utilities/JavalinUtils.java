package com.revature.ecommerce.utilities;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.*;

import java.io.IOException;

import com.revature.ecommerce.controllers.CartController;
import com.revature.ecommerce.controllers.OrderController;
import com.revature.ecommerce.controllers.OrderHistoryController;
import com.revature.ecommerce.controllers.ProductController;
import com.revature.ecommerce.controllers.UserController;
import com.revature.ecommerce.dao.AddressDAO;
import com.revature.ecommerce.dao.CartDAO;
import com.revature.ecommerce.dao.OrderDAO;
import com.revature.ecommerce.dao.OrderItemDAO;
import com.revature.ecommerce.dao.ProductDAO;
import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.service.AddressService;
import com.revature.ecommerce.service.CartService;
import com.revature.ecommerce.service.OrderHistoryService;
import com.revature.ecommerce.service.OrderItemService;
import com.revature.ecommerce.service.OrderService;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.service.TokenService;
import com.revature.ecommerce.service.UserService;

import io.javalin.Javalin;

public class JavalinUtils {

	public Javalin getJavalin() throws IOException {
		UserController userController = new UserController(new UserService(new UserDAO()), new TokenService());
		ProductController productController = new ProductController(new ProductService(new ProductDAO()),
				new TokenService());
		OrderController orderController = new OrderController(new OrderService(new OrderDAO()), new TokenService());
		CartController cartController = new CartController(
				new CartService(
						new CartDAO(),
						new OrderItemService(new OrderItemDAO()),
						new OrderService(new OrderDAO()),
						new AddressService(new AddressDAO())
						),
				new TokenService());
		OrderHistoryController orderHistController = new OrderHistoryController(new OrderHistoryService(new OrderDAO()), new TokenService());
		
		return Javalin.create(config -> {
			config.router.apiBuilder(() -> {
				path("/users", () -> {
					post("/register", userController::register);
					post("/login", userController::login);
					get(userController:: getAllUsers);
					put( userController::updateUser);
				});
				path("/products", ()-> {
					post(productController::addProduct);
					get("/catalog", productController::getCatalog);
					get(productController:: getAllProducts);
				    get("{id}", productController::getProduct);
    				put(productController::updateProduct);
					delete(productController::removeProduct);
					delete("{id}", productController::deleteProduct);
				});
				path("/carts", ()-> {
					post(cartController::createCart);
					get("{id}",cartController::getCart);
					put(cartController::addItemToCart);
					// takes in product id
					put("{id}", cartController::removeItemFromCart);
					//delete cart by id- create order takes in address
					delete("{id}", cartController::checkout);
					delete(cartController::hardDelete);
				});
				path("/orders", ()->{
					post(orderController:: createOrder);
					get(orderController:: getAllOrders);
					get("{id}", orderController :: getOrder);
					put(orderController::updateOrder);
					delete(orderController::cancelOrder);
				});
				path("/orderhistory", ()->{
					post(orderHistController:: createOrderHistory);
					get("{user_id}", orderHistController:: getOrderHistory);
					put(orderHistController:: updateOrderHistory);
				});
			});
		});
	}

	
}
