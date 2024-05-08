package com.cadd.foodplaza.dao;

import java.util.List;

import com.cadd.foodplaza.pojo.Cart;

public interface CartDao {
	boolean addtoCart(Cart ct);//variable data all add to cart
	boolean deleteCart(int cartId); 
	List<Cart>showCart();
	

}
