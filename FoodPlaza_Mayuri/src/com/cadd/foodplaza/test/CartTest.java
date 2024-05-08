package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.CartDaoImpl;
import com.cadd.foodplaza.dao.CustomerDaoImpl;
import com.cadd.foodplaza.pojo.Cart;

public class CartTest {
	public static void main(String[] args) {
		
		int choice,foodQty,cartId;
		String customerEmailid,foodName;
		boolean flag;
		Cart c=new Cart();
		CartDaoImpl cd= new CartDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		do {
		
		
		System.out.println("********************WELCOME TO CADD PLAZA CART ********************\n1.Add to Cart\n2.Delete Cart\n3.Display Cart\n4.Exit \nEnter your Choice:");
		choice=sc.nextInt();
		switch(choice) 
		
		{
		case 1:
			System.out.println("***********Enter below Details to Add to Cart***********");
			System.out.println("Enter the CartDetails(CustomerEmailid,foodName,foodQty)for adding into Cart");
			customerEmailid=sc.next();
			foodName=sc.next();
			foodQty=sc.nextInt();
			
			
			c.setCustomerEmailid(customerEmailid);
			c.setFoodName(foodName);
			c.setFoodQty(foodQty);
			
			flag=cd.addtoCart(c);
			if(flag)
			{
				System.out.println("Cart Added Successfully");
			}
			else
			{
				System.out.println("Cart Adding failed");
			}
			break;
		case 2:
			System.out.println("***********Enter ID to Delete Cart***********");
			System.out.println("Enter CArt Id:");
			cartId=sc.nextInt();
			
			c.setCartId(cartId);
			flag=cd.deleteCart(cartId);
			if(flag==true)
			{
				System.out.println("delete cart successfully");
			}
			else
			{
				System.out.println("cart delete Failed");
			}
			break;
		case 3:
			System.out.println("***********Display Details of Cart***********");
			ArrayList<Cart>af=new ArrayList<Cart>();
			af=cd.showCart(); 
			
			for(Cart i:af)
			{
				System.out.println("Cart ID:"+i.getCartId());
				System.out.println("Food Qty:"+i.getFoodQty());
				System.out.println("Customer Emailid:"+i.getCustomerEmailid());
				System.out.println("Food ID:"+i.getFoodId());
				System.out.println("Food Name:"+i.getFoodName());
						
			}
			break;
		case 4:
			System.out.println("Khatam Tata Bye Bye......Ghari Ja....");
			break;
			default:
			System.out.println("Invalid Choice...Please Enter Current Choice");
		
		}
		}while(choice<4);
	}

}
