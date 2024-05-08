package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.FoodDaoImpl;
import com.cadd.foodplaza.pojo.Food;

public class FoodTest {
	public static void main(String[] args) {
		
		int choice,foodId;
		String foodName,foodType,foodCategory;
		double foodPrice;
		boolean flag;
		Food f=new Food();
		FoodDaoImpl fd= new FoodDaoImpl();//addfood method call
		
		Scanner sc=new Scanner(System.in);
		
		
		do {
			System.out.println("********************WELCOME TO CADD FOODPLAZA*******************\n1.Add Food\n2.Update Food\n3.Delete Food\n4.Display Food By ID\n5.Display All Food\n6.Exit");
			System.out.println("Enter your Choice:");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("------------------Enter Below Details to add Food------------------");
				System.out.println("Enter food Name,Food Type,Food Category,Food Price");
				foodName=sc.next();
				foodType=sc.next();
				foodCategory=sc.next();
				foodPrice=sc.nextDouble();
				
				//Food f=new Food();
				f.setFoodName(foodName);
				f.setFoodType(foodType);
				f.setFoodCategory(foodCategory);
				f.setFoodPrice(foodPrice);
				
//				FoodDaoImpl fd= new FoodDaoImpl();//addfood method call
				 flag=fd.addFood(f);
				 
				if(flag==true)
				{
					System.out.println("Food added successfully...");
				}
				else
				{
					System.out.println("Food adding failed");
				}
				break;
				
			case 2:
				System.out.println("------------------Enter ID to Update Food of your choice------------------");
				System.out.println("Enter the FoodId");
				foodId=sc.nextInt();
				
				System.out.println("Enter the Food Name:");
				foodName=sc.next();
				System.out.println("Enter the Food Type:");
				foodType=sc.next();
				System.out.println("Enter the Food Category:");
				foodCategory=sc.next();
				System.out.println("Enter the Food Price:");
				foodPrice=sc.nextDouble();
				
				f.setFoodId(foodId);
				f.setFoodName(foodName);
				f.setFoodType(foodType);
				f.setFoodCategory(foodCategory);
				f.setFoodPrice(foodPrice);
				
//				FoodDaoImpl fy= new FoodDaoImpl();//addfood method call
				flag=fd.updateFood(f);
				
				if(flag==true)
				{
					System.out.println("Food Update successfully...");
				}
				else
				{
					System.out.println("Food update failed");
				}
				break;
				
				
				
				
			case 3:
				System.out.println("------------------Enter ID to Delete Food------------------");
				System.out.println("Enter the FoodId");
				foodId=sc.nextInt();
				
                flag=fd.deleteFood(foodId);
				
				if(flag==true)
				{
					System.out.println("Food Delete successfully...");
				}
				else
				{
					System.out.println("Food Delete failed");
				}
				break;
			case 4:
				
				System.out.println("------------------Enter ID to Display Specific Food------------------");
				System.out.println("Enter the FoodId");
				foodId=sc.nextInt();
				
                f=fd.displayFoodById(foodId);
                
                System.out.println("*****FOOD DETAILS*****");
                System.out.println(f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice());
				break;
			case 5:
				System.out.println("------------------Existing Food Details ------------------");
				ArrayList<Food>af=new ArrayList<Food>();
				af=fd.displayAllFood();
				
				for(Food i:af)
				{
					System.out.println("Food ID:"+i.getFoodId());
					System.out.println("Food Name:"+i.getFoodName());
					System.out.println("Food Type:"+i.getFoodType());
					System.out.println("Food Category"+i.getFoodCategory());
					System.out.println("Food Price:"+i.getFoodPrice());
					System.out.println();
				}
				break;
			case 6:
				System.out.println("Khatam Tata bye bye....Ghari jaa....");
				break;
			default:
				System.out.println("Invalid Choice...Please Enter current choice...");
			
			}
		}while(choice<6);
	}

}
