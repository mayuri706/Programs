package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.CustomerDaoImpl;
import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;

public class CustomerTest {
	

	public static void main(String[] args) {
		Customer c=new Customer();
		CustomerDaoImpl cd= new CustomerDaoImpl();
		boolean flag ;
	
	int choice,customerId;
	String customerName,customerAddress,customerEmailid,customerPassword;
	Long customerContact;
	
	do {
		Scanner sc=new Scanner(System.in);
		System.out.println("********************WELCOME TO CADD CUSTOMER********************\n1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.Display Customer By ID\n5.Display All Customer\n6.Exit\n Enter your Choice:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("------------------Enter Below Details to add Customer------------------");
			System.out.println("Customer Name,Customer Address,Customer Contact,Customer Email Id,Customer Password ");
			customerName = sc.next();
			customerAddress=sc.next();
			customerContact=sc.nextLong();
			customerEmailid=sc.next();
			customerPassword=sc.next();	
			
//			Customer c=new Customer();
			
			c.setCustomerName(customerName);
			c.setCustomerAddress(customerAddress);
			c.setCustomerContact(customerContact);
			c.setCustomerEmailid(customerEmailid);
			c.setCustomerPassword(customerPassword);
			
//			CustomerDaoImpl cd= new CustomerDaoImpl();
			 flag = cd.addCustomer(c);
			if(flag==true)
			{
				System.out.println("Customer added successfully...");
			}
			else
			{
				System.out.println("Customer Adding Faild");
			}
			
			break;
		case 2:
			System.out.println("------------------Enter ID to Update Customer of your choice------------------");
			System.out.println("Enter the Customer Id");
			customerId=sc.nextInt();
			System.out.println("Enter the Customer Name:");
			customerName = sc.next();
			System.out.println("Enter the Customer Address:");
			customerAddress = sc.next();
			System.out.println("Enter the Customer Contact:");
			customerContact = sc.nextLong();
			System.out.println("Enter the Customer EmailId:");
			customerEmailid = sc.next();
			System.out.println("Enter the Customer password:");
			customerPassword = sc.next();
			
			c.setCustomerId(customerId);
			c.setCustomerName(customerName);
			c.setCustomerAddress(customerAddress);
			c.setCustomerContact(customerContact);
			c.setCustomerEmailid(customerEmailid);
			c.setCustomerPassword(customerPassword);
			 flag = cd.updateCustomer(c);
			if(flag==true)
			{
				System.out.println("Customer Update successfully...");
			}
			else
			{
				System.out.println("Customer Update Faild");
			}
			
			break;
		case 3:
			System.out.println("------------------Enter ID to Delete Customer------------------");
			System.out.println("Enter Customer Id:");
			customerId=sc.nextInt();
			
			c.setCustomerId(customerId);
			flag = cd.deleteCustomer(customerId);
			if(flag==true)
			{
				System.out.println("Customer Delete successfully...");
			}
			else
			{
				System.out.println("Customer Delete Faild");
			}
			
			break;
		case 4:
			System.out.println("------------------Enter ID to Display Specific Customer------------------");
			System.out.println("Enter the CustomerId");
			customerId=sc.nextInt();
			
            c=cd.displayCustomerById(customerId);
            
            System.out.println("*****CUSTOMER DETAILS*****");
            System.out.println(c.getCustomerName()+" "+c.getCustomerAddress()+" "+c.getCustomerContact()+" "+c.getCustomerEmailid()+" "+c.getCustomerPassword());
			break;
		case 5:
			System.out.println("------------------Existing Customer Details ------------------");
			
			ArrayList<Customer>af=new ArrayList<Customer>();
			af=cd.displayAllCustomer();
			
			for(Customer i:af)
			{
				System.out.println("Customer ID:"+i.getCustomerId());
				System.out.println("Customer Name:"+i.getCustomerName());
				System.out.println("Customer Address:"+i.getCustomerAddress());
				System.out.println("Customer Contact:"+i.getCustomerContact());
				System.out.println("Customer Emailid"+i.getCustomerEmailid());
				System.out.println("Customer Password:"+i.getCustomerPassword());
				
				System.out.println();
			}
			break;
		case 6:
			System.out.println("pot bharl aasel tar nigha aata");
			break;
		default:
			System.out.println("Invalid Choice...Please Enter current choice...");
		}
	}while(choice<6);
	}
}

