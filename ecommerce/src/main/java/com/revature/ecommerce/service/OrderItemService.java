package com.revature.ecommerce.service;

import java.util.List;
import com.revature.ecommerce.dao.OrderItemDAO;
import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.OrderItem;
import com.revature.ecommerce.models.Product;

public class OrderItemService {
	private final OrderItemDAO itemDao;

	public OrderItemService(OrderItemDAO itemDao) {
		this.itemDao = itemDao;
	}
// add product to order item in cart
	public OrderItem createOrderItem(Product prod,Cart cart) {
		
		OrderItem newitem = new OrderItem();
		newitem.setProductId(prod.getId());
		newitem.setProductQuantity(1);
		newitem.setPrice(prod.getPrice());
		newitem.setOrderId(cart.getItemsId());
		
		itemDao.save(newitem);
		return newitem;
		
	}

	
	// update product quantity
	public OrderItem addItem(Product prod, Cart cart) {
	// look up orderItem by product ID
		List<OrderItem> listofItems= itemDao.findByProductId(prod.getId());
		//see if product is already listed in cart
		 for(OrderItem item: listofItems) {
			 if (item.getProductId().equals(prod.getId())) {
				//if so update quantity and price
					item.setPrice(item.getPrice() + prod.getPrice());
					item.setProductQuantity(item.getProductQuantity()+1);
					itemDao.update(item);
					return item; 
			 }
		 }
		//if not add product to orderItem 
		
			 OrderItem neworder=createOrderItem(prod,cart);
			 return neworder;
			 
	}

	public void removeItem(Product prod, String itemID) {
		List<OrderItem> items =itemDao.findByProductId(prod.getId());
		
		for(OrderItem item : items) {
			if(item.getOrderId().equals(itemID)) {
				if(item.getProductQuantity() > 1) {
					item.setProductQuantity(item.getProductQuantity()-1);
					item.setPrice(item.getPrice()-prod.getPrice());
					itemDao.update(item);
					return;
				} 
				itemDao.delete(item.getId());
			}
		}
		
	}
	
	
	public List<OrderItem> getOrderItemsbyOrderId(String orderId) {
		
		return itemDao.findByOrderId(orderId);
	}

}
