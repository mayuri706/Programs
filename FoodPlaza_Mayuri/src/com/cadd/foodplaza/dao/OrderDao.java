package com.cadd.foodplaza.dao;

import java.util.List;

import com.cadd.foodplaza.pojo.Order;

public interface OrderDao 
{
	boolean placeOrder(String customerEmailid);
	
	List<Order>showOrders();
	

}
