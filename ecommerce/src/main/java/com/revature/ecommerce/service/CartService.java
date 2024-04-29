package com.revature.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.revature.ecommerce.dao.CartDAO;
import com.revature.ecommerce.dao.ProductDAO;
import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.Order;
import com.revature.ecommerce.models.OrderItem;
import com.revature.ecommerce.models.Product;

public class CartService {
	private final CartDAO cartDao;
	private final OrderItemService itemsrv;

	public CartService(CartDAO cartDAO, OrderItemService itemsrv) {
		this.cartDao = cartDAO;
		this.itemsrv = itemsrv;
	}

	public Cart initializeCart(String uId) {
		Cart cart = new Cart();
		cart.setUserId(uId);
		cart.setQuantity(0);
		cart.setStatus("Initialized");
		cart.setTotal(0);

		cartDao.save(cart);
		return cart;
	}

	public Cart addItem(String productId, String userId) {
		
		// look up cart and product
		Product prod = new ProductDAO().findByID(productId);
		Cart foundcart = cartDao.findByUserID(userId);

		if (foundcart.getUserId().equalsIgnoreCase(userId)) {

			OrderItem item = itemsrv.addItem(prod, foundcart);
			// update cart's quantity
			foundcart.setQuantity(foundcart.getQuantity() + 1);
			// update total
			foundcart.setTotal(foundcart.getTotal() + prod.getPrice());
			// update status
			foundcart.setStatus("In Progress");
			// update cart in db
			cartDao.update(foundcart);
			// System.out.println("cart service found the cart" + foundcart.getItemsId());
			return foundcart;
		}
		// if cart not found initialize new cart and create item.
		Cart newcart = initializeCart(userId);
		// System.out.println("cart is empty");
		OrderItem item = itemsrv.createOrderItem(prod, newcart);
		return newcart;
	}

	public Cart removeItem(String prodid, String userId) {
		Product prod = new ProductService(new ProductDAO()).getProductById(prodid);
		Cart cart = cartDao.findByUserID(userId);
		List<OrderItem> items = itemsrv.getOrderItemsbyOrderId(cart.getItemsId());
		for (OrderItem item : items) {
			if (item.getProductId().equals(prodid)) {
				
				if (item.getProductQuantity() == 0) {
					return cart;
				}
				itemsrv.removeItem(prod, cart.getItemsId());
				cart.setQuantity(cart.getQuantity() - 1);
				cart.setTotal(cart.getTotal() - prod.getPrice());
				cartDao.update(cart);
				break;
			}
		}
		return cart;
	}

	public Order checkout(Cart cart, Order order) {
		// todo
		return null;
	}

	public boolean ifCartIsNotUnique(String id) {

		Optional<Cart> optCart = Optional.of(cartDao.findByUserID(id));

		if (optCart.get().getUserId() == null) {
			return false;
		} else {
			return true;
		}
	}
}
