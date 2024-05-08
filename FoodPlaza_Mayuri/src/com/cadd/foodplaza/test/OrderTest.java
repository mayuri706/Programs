package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cadd.foodplaza.dao.OrderDaoImpl;
import com.cadd.foodplaza.pojo.Order;

public class OrderTest {
	public static void main(String[] args) {
		int orderId,choice;
		String customerEmailid,orderDate,foodName;
		double totalBill;
		boolean flag;
		Order or=new Order();
		OrderDaoImpl od=new OrderDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("********************Welcome to Food Plaza(Order Module)********************");
		System.out.println("1.Place Order");
		System.out.println("2.Show Order");
		System.out.println("Enter your Choice:");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("*************************PLACE ORDER*************************");
			System.out.println("Enter Customer EmailId:");
			customerEmailid=sc.next();
			
			or.setCustomerEmailid(customerEmailid);
			
			flag =od.placeOrder(customerEmailid);
			
			if(flag==true)
			{
				System.out.println("Place order Successfully");
			}
			else
			{
				System.out.println(" place order failed");
			}
			break;
			
		case 2:
			System.out.println("********************Show Orders********************");
			List<Order>af=new ArrayList<Order>();
			af=od.showOrders();
			
			for(Order i:af)
			{
				System.out.println("Order Id:"+i.getOrderId());
				System.out.println("Customer EmailId:"+i.getCustomerEmailid());
				System.out.println("Food Name:"+i.getFoodName());
				System.out.println("Order Date:"+i.getOrderDate());
				System.out.println("Total Bill:"+i.getTotalBill());
				
			}
			break;
			
			default:
				System.out.println("Invalid Choice");
		}
		
		
	}

}
