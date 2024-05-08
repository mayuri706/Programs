package com.cadd.foodplaza.pojo;
//bean class or pojo class
public class Food {
	
	
	private int foodId;//incapsilation
	private double foodPrice;//incapsilation
    private String foodName,foodType,foodCategory;//incapsilation
//    public Food(int foddId, double foodPrice, String foodName, String foodType, String foodCategory) {
//		super();
//		this.foddId = foddId;
//		this.foodPrice = foodPrice;
//		this.foodName = foodName;
//		this.foodType = foodType;
//		this.foodCategory = foodCategory;
//	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

    
}
