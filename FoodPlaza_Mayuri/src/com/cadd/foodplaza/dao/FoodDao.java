package com.cadd.foodplaza.dao;
import java.util.ArrayList;

import com.cadd.foodplaza.pojo.Food;

//admin
public interface FoodDao {
	
 boolean addFood(Food f);//contain pojo class details
 
  boolean updateFood(Food f);
  
  boolean deleteFood(int foodId);
  
  Food displayFoodById(int foodId);
  
  ArrayList<Food>displayAllFood();
}
